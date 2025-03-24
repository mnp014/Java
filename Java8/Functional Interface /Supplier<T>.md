📌 `Purpose:`
Represents a function that takes no input and returns a result (T).
Used when you want to generate or provide values lazily.

✅ Signature:
```java
@FunctionalInterface
public interface Supplier<T> {
    T get();
}
```
💡 Example:
```java
Supplier<Double> randomSupplier = () -> Math.random();

System.out.println(randomSupplier.get()); // Output: random double
```
