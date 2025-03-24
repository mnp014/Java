📌 `Purpose:`
A special case of [Function<T, R>](https://github.com/mnp014/Java/blob/master/Java8/Functional%20Interface%20/Function%3CT%2C%20R%3E.md) where input and output are of the same type.

✅ Signature:
```java
@FunctionalInterface
public interface UnaryOperator<T> extends Function<T, T> {
    T apply(T t);
}
```
💡 Example:
```java
UnaryOperator<String> toUpper = str -> str.toUpperCase();

System.out.println(toUpper.apply("hello")); // Output: HELLO
```
