🔍 `What it is:`
A lambda expression is a shorthand for implementing a functional interface using concise syntax. 📦 Introduced in: Java 8  
💡 `Think of it as:` An anonymous function (like a lightweight method without a name).


---
🔧 Example:
 - Traditional Usage:
```java


Runnable r1 = new Runnable() {
    public void run() {
        System.out.println("Running!");
    }
};
```
 - Using Lambda:
```java
Runnable r2 = () -> System.out.println("Running!");
```
---

🔥 Key benefits:
 - Cleaner, shorter code
 - Eliminates boilerplate for anonymous classes
 - Used extensively with Streams and functional interfaces
