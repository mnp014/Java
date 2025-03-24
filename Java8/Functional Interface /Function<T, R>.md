📌 `Purpose:`
Represents a function that takes an input (T) and returns a result (R).

✅ Signature:
```java 
@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);
}

```

💡 Example:
```java
Function<String, Integer> lengthFunc = str -> str.length();

System.out.println(lengthFunc.apply("Hello")); // Output: 5

```
