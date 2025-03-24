📌 Purpose:
A special case of Function<T, R> where input and output are of the same type.

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
