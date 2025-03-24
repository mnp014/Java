📌 `Purpose:`
Represents a condition that evaluates to a boolean result for a single input.

✅ Signature:
```java
@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}
```
💡 Example:
```java
Predicate<String> isLongName = name -> name.length() > 5;

System.out.println(isLongName.test("Charlie")); // Output: true
```
---
Also refer [Predicate Chaining](https://github.com/mnp014/Java/blob/master/Java8/Functional%20Interface%20/Predicate%20Chaining.md)
