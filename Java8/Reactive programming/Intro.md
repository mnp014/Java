🔍 `What it is?:`
Reactive programming is about building systems that are asynchronous, non-blocking, and event-driven.

💡 `Think of it as:` A system that reacts to data as it comes, like a live stream. 

----
📦 Common libraries:
 - `Project Reactor` ( [Mono\<T>](https://github.com/mnp014/Java/blob/master/Java8/Reactive%20programming/Mono%3CT%3E.md) , [Flux\<T>](https://github.com/mnp014/Java/blob/master/Java8/Reactive%20programming/Flux%3CT%3E.md) )
 - `RxJava` (Observable<T>, Single<T>, Maybe<T>, Completable, Observer<T>, Schedulers)
 - Used in Spring WebFlux  

----
🔧 Example (using Reactor):
```java
Mono.just("Hello")
    .map(String::toUpperCase)
    .subscribe(System.out::println); // Prints: HELLO
```
----
🔥 `Key benefits:`
 - Efficient resource usage (no thread blocking)
 - Ideal for real-time applications (chat, live feeds)
 - Great for microservices
