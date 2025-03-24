You can chain predicates using:
 - `.and()`
 - `.or()`
 - `.negate()`

```java
Predicate<String> startsWithA = s -> s.startsWith("A");
Predicate<String> longName = s -> s.length() > 3;

Predicate<String> complex = startsWithA.and(longName);

System.out.println(complex.test("Amit")); // true
System.out.println(complex.test("Aj"));   // false
```
