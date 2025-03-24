🔍 `What it is:`
Method references are a shortcut to use an existing method as a lambda.
📦 Introduced in: Java 8

💡 `Think of it as:` A pointer to a method you already wrote.

---
🔧 Syntax:

```java
ClassName::methodName
```

🔧 Example:
```java
List<String> names = List.of("Alice", "Bob");

names.forEach(System.out::println); // instead of: names.forEach(name -> System.out.println(name));
```

---

🔥 Key benefits:
 - Makes lambdas even more concise
 - Enhances readability
