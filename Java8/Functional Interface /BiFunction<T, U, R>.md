📌 `Purpose:`
Represents a function that takes two arguments (T and U) and returns a result (R).

✅ Signature:
```java
@FunctionalInterface
public interface BiFunction<T, U, R> {
    R apply(T t, U u);
}
```
💡 Example:
```java
BiFunction<Integer, Integer, String> sumAsString = (a, b) -> "Sum: " + (a + b);

System.out.println(sumAsString.apply(10, 20)); // Output: Sum: 30
```
