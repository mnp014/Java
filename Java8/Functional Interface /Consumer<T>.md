📌 `Purpose:`
Represents an operation that takes an input (T) and returns nothing (void).
Used for side-effects like printing, saving, logging, etc.

✅ Signature:
```java
@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}
```
💡 Example:
```java
Consumer<String> printUpper = s -> System.out.println(s.toUpperCase());

printUpper.accept("hello"); // Output: HELLO

```
