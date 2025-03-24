 ✅ Summary Table
| Component       | Role                                | Key Methods                                             |
|-----------------|-------------------------------------|---------------------------------------------------------|
| [`Publisher<T>`](https://github.com/mnp014/Java/blob/master/Java8/Reactive%20programming/Reactive%20Streams.md#1-publishert)  | Emits data to a `Subscriber`         | `subscribe(Subscriber<T>)`                              |
| [`Subscriber<T>`](https://github.com/mnp014/Java/blob/master/Java8/Reactive%20programming/Reactive%20Streams.md#2-subscribert) | Consumes data from a `Publisher`     | `onSubscribe()`, `onNext()`, `onComplete()`, `onError()`|
| [`Subscription`](https://github.com/mnp014/Java/blob/master/Java8/Reactive%20programming/Reactive%20Streams.md#3-subscription)  | Manages the flow between both sides  | `request(n)`, `cancel()`                                |

----

🔁 How They Work Together:
 - Publisher emits data
 - Subscriber subscribes to Publisher
 - Publisher calls onSubscribe(...) passing a Subscription
 - Subscriber uses subscription.request(n) to control how many items it receives
 - Items are sent via onNext(...), and finished with onComplete() or onError(...)

----

#### 1) Publisher\<T>

📌 `Purpose:`
Represents a provider of a potentially unbounded number of sequenced elements, published asynchronously to a subscriber, according to the Reactive Streams specification.

✅ Signature:

```java
@FunctionalInterface
public interface Publisher<T> {
    void subscribe(Subscriber<? super T> subscriber);
}
```

💡 Example:

```java
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class SimplePublisher implements Publisher<String> {
    @Override
    public void subscribe(Subscriber<? super String> subscriber) {
        subscriber.onSubscribe(new Subscription() {
            @Override
            public void request(long n) {
                subscriber.onNext("Hello");
                subscriber.onNext("Reactive");
                subscriber.onNext("Streams");
                subscriber.onComplete();
            }

            @Override
            public void cancel() {
                // handle cancellation if needed
            }
        });
    }

    public static void main(String[] args) {
        SimplePublisher publisher = new SimplePublisher();

        publisher.subscribe(new Subscriber<>() {
            @Override
            public void onSubscribe(Subscription s) {
                s.request(Long.MAX_VALUE); // request all data
            }

            @Override
            public void onNext(String s) {
                System.out.println("Received: " + s);
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error: " + t.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("Done!");
            }
        });
    }
}
```

🖨️ Output:

```makefile
Received: Hello  
Received: Reactive  
Received: Streams  
Done!
```
✅ Summary

|Element	|Description|
|---------|-----------|
|Publisher<T>	|Core reactive type that emits data to Subscribers|
|Used in	|RxJava, Project Reactor, Akka Streams, Spring WebFlux|
|Extended by	|Mono<T> and Flux<T> in Project Reactor|
|Key method	|.subscribe(Subscriber<? super T> subscriber)|

---

#### 2) Subscriber\<T>
📌 `Purpose:`
Represents a consumer that subscribes to a Publisher<T> and receives a sequence of events (data, completion, or error), while controlling the flow using a Subscription.

✅ Signature:

```java
public interface Subscriber<T> {
    void onSubscribe(Subscription s);
    void onNext(T t);
    void onError(Throwable t);
    void onComplete();
}
```

💡 Example:

```java
Subscriber<String> subscriber = new Subscriber<>() {
    @Override
    public void onSubscribe(Subscription s) {
        System.out.println("Subscribed!");
        s.request(Long.MAX_VALUE); // Request all items
    }

    @Override
    public void onNext(String item) {
        System.out.println("Received: " + item);
    }

    @Override
    public void onError(Throwable t) {
        System.err.println("Error: " + t.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("Stream complete!");
    }
};

```

---

#### 3) Subscription
   
📌 `Purpose:`
Represents a link between a Publisher and a Subscriber, used to control demand (backpressure) and allow cancellation.

✅ Signature:

```java
public interface Subscription {
    void request(long n); // Request n items
    void cancel();        // Cancel the subscription
}
```

💡 Example:

```java
Subscription subscription = new Subscription() {
    @Override
    public void request(long n) {
        System.out.println("Requesting " + n + " items");
        // Trigger item emission logic in Publisher
    }

    @Override
    public void cancel() {
        System.out.println("Subscription cancelled");
    }
};
```

