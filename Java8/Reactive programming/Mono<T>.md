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

| Feature       | `Flux<T>`                                        | `Mono<T>`                                      |
|----------------|------------------------------------------------|--------------------------------------------------|
| Emits         |  0 to N items                                        |0 or 1 item                                   |
| Use case      |  Streams, multiple results, Server-Sent Events (SSE) |REST response, DB fetch, 1 result             |
| Backpressure  | Supported                                            |Supported                                     | 
| Part of       |  Project Reactor  (Reactive Streams)                 |Project Reactor (Reactive Streams)            |
| Async?        |  ✅                                                 |  ✅                                          | 
| Blocking?     |  ❌                                                 |  ❌                                          |           
