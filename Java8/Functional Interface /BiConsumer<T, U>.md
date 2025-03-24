📌 `Purpose:`
Performs an action (with side effects) on two inputs, but returns no result (returns void).

✅ Signature:
```java
@FunctionalInterface
public interface BiConsumer<T, U> {
    void accept(T t, U u);
}
```
💡 Example:
```java
BiConsumer<String, Integer> printNameAge = (name, age) -> 
    System.out.println(name + " is " + age + " years old");

printNameAge.accept("Alice", 30); // Output: Alice is 30 years old
```
