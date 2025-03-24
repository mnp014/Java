📌 `Purpose:`
A special case of [BiFunction<T, U, R>](https://github.com/mnp014/Java/blob/master/Java8/Functional%20Interface%20/BiFunction%3CT%2C%20U%2C%20R%3E.md) where both inputs and the output are the same type.

✅ Signature:
```java
@FunctionalInterface
public interface BinaryOperator<T> extends BiFunction<T, T, T> {
    T apply(T t1, T t2);
}
```
💡 Example:
```
BinaryOperator<Integer> max = (a, b) -> a > b ? a : b;

System.out.println(max.apply(5, 10)); // Output: 10
```
----
✅ Main Difference:

| Feature             | `BiFunction<T, U, R>`                                     | `BinaryOperator<T>`                                      |
|---------------------|-----------------------------------------------------------|-----------------------------------------------------------|
| Type parameters      | Takes two different input types (`T`, `U`) and returns `R` | Takes two inputs of the same type (`T`, `T`) and returns `T` |
| Interface extends    | `BiFunction<T, U, R>` is a top-level interface            | `BinaryOperator<T>` extends `BiFunction<T, T, T>`         |
| Use case             | Generic two-input transformation                          | Combining two values of same type (e.g., reduce)          |
| Return type          | Can be a different type than inputs                       | Must be same type as inputs                               |
