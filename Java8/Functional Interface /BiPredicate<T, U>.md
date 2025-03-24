📌 `Purpose:`
Evaluates a boolean condition on two inputs.

✅ Signature:
```java
@FunctionalInterface
public interface BiPredicate<T, U> {
    boolean test(T t, U u);
}
```
💡 Example:
```java
BiPredicate<String, String> isEqualIgnoreCase = (s1, s2) -> s1.equalsIgnoreCase(s2);

System.out.println(isEqualIgnoreCase.test("hello", "HELLO")); // Output: true
```
