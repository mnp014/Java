🔍 `What it is:`
Declarative pipelines describe what to do, not how to do it, using a series of operations chained together.

💡 `Think of it as:` A recipe — you describe the steps, and the system handles the execution.

---
📦 Appears in:
 - Java Streams
 - Build tools (like Jenkins pipelines)
 - Reactive code

---
 🔧 `Example:`
```java
List.of(1, 2, 3, 4, 5).stream()
    .filter(i -> i % 2 == 0)   // Step 1: even numbers
    .map(i -> i * 10)          // Step 2: multiply by 10
    .forEach(System.out::println); // Step 3: print
```
---

🔥 Key benefits:
 - More readable
 - Encourages immutability and clean code
 - Easier to maintain and parallelize

