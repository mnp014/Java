📌 `Purpose:`
Represents a reactive publisher that emits 0 to N items — like a stream of events/data.

✅ Signature:

```java
public final class Flux<T> extends Publisher<T>
```
##### (Flux also implements the Publisher<T> interface)

💡 Example:

```java
Flux<String> flux = Flux.just("Java", "Spring", "Reactor");

flux.subscribe(System.out::println);

// Output:
// Java
// Spring
// Reactor
```

---

Other creation methods:
```java
Flux.empty();       // emits nothing
Flux.range(1, 5);   // emits 1 to 5
Flux.fromIterable(List.of("A", "B", "C"));
```

---

| Feature       | [`Mono<T>`](https://github.com/mnp014/Java/blob/master/Java8/Reactive%20programming/Mono%3CT%3E.md)                                      | `Flux<T>`                                        |
|----------------|------------------------------------------------|--------------------------------------------------|
| Emits         | 0 or 1 item                                     | 0 to N items                                     |
| Use case      | REST response, DB fetch, 1 result               | Streams, multiple results, Server-Sent Events (SSE) |
| Backpressure  | Supported                                       | Supported                                        |
| Part of       | Project Reactor (Reactive Streams)              | Project Reactor                                  |
| Async?        |  ✅                                             |  ✅                                             | 
| Blocking?     |  ❌                                             |  ❌                                             |    
