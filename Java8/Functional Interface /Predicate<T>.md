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
