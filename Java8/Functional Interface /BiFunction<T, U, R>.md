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
----
✅ Main Difference:
| Feature             | [`BinaryOperator<T>`](https://github.com/mnp014/Java/blob/master/Java8/Functional%20Interface%20/BinaryOperator%3CT%3E.md)                                      | `BiFunction<T, U, R>`                                     |
|---------------------|-----------------------------------------------------------|-----------------------------------------------------------|
| Type parameters      | Takes two inputs of the same type (`T`, `T`) and returns `T` | Takes two different input types (`T`, `U`) and returns `R` |
| Interface extends    | `BinaryOperator<T>` extends `BiFunction<T, T, T>`         | `BiFunction<T, U, R>` is a top-level interface            |
| Use case             | Combining two values of same type (e.g., reduce)          | Generic two-input transformation                          |
| Return type          | Must be same type as inputs                               | Can be a different type than inputs                       |
