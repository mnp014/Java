📌 `Purpose:`
Represents a reactive publisher that emits at most one item — zero or one.  
Used for asynchronous single-value or empty responses.

✅ Signature:

```java
public final class Mono<T> extends Publisher<T>
```
##### (Mono implements the Reactive Streams Publisher interface)

💡 Example:

```java
Mono<String> mono = Mono.just("Hello Reactive World");

mono.subscribe(System.out::println); // Output: Hello Reactive World
```

Other creation methods:
```java
Mono.empty();                     // emits nothing and completes
Mono.error(new RuntimeException("Error!")); // emits an error
```

---

| Feature       | [`Flux<T>`](https://github.com/mnp014/Java/blob/master/Java8/Reactive%20programming/Flux%3CT%3E.md)                                        | `Mono<T>`                                      |
|----------------|------------------------------------------------|--------------------------------------------------|
| Emits         |  0 to N items                                        |0 or 1 item                                   |
| Use case      |  Streams, multiple results, Server-Sent Events (SSE) |REST response, DB fetch, 1 result             |
| Backpressure  | Supported                                            |Supported                                     | 
| Part of       |  Project Reactor  ([Reactive Streams](https://github.com/mnp014/Java/blob/master/Java8/Reactive%20programming/Intro.md))                 |Project Reactor ([Reactive Streams](https://github.com/mnp014/Java/blob/master/Java8/Reactive%20programming/Intro.md))            |
| Async?        |  ✅                                                 |  ✅                                          | 
| Blocking?     |  ❌                                                 |  ❌                                          |           
