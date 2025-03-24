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
