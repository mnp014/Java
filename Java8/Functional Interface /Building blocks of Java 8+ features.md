Following are the building blocks of Java 8+ features like:
1) Streams API
2) Lambdas
3) Method references
4) Reactive programming
5) Declarative pipelines

| Type      | Examples                             | Purpose                                      |
|-----------|--------------------------------------|----------------------------------------------|
| Function  | [`Function<T,R>`](https://github.com/mnp014/Java/blob/master/Java8/Functional%20Interface%20/Function%3CT%2C%20R%3E.md), [`BiFunction<T,U,R>`](https://github.com/mnp014/Java/blob/master/Java8/Functional%20Interface%20/BiFunction%3CT%2C%20U%2C%20R%3E.md) | Transform input to output                    |
| Consumer  | [`Consumer<T>`](https://github.com/mnp014/Java/blob/master/Java8/Functional%20Interface%20/Consumer%3CT%3E.md), [`BiConsumer<T,U>`](https://github.com/mnp014/Java/blob/master/Java8/Functional%20Interface%20/BiConsumer%3CT%2C%20U%3E.md)     | Perform actions (void return)                |
| Supplier  | [`Supplier<T>`](https://github.com/mnp014/Java/blob/master/Java8/Functional%20Interface%20/Supplier%3CT%3E.md)                        | Provide/generate values                      |
| Predicate | [`Predicate<T>`](https://github.com/mnp014/Java/blob/master/Java8/Functional%20Interface%20/Predicate%3CT%3E.md), [`BiPredicate<T,U>`](https://github.com/mnp014/Java/blob/master/Java8/Functional%20Interface%20/BiPredicate%3CT%2C%20U%3E.md)   | Test/evaluate boolean conditions             |
| Operator  | [`UnaryOperator<T>`](https://github.com/mnp014/Java/blob/master/Java8/Functional%20Interface%20/UnaryOperator%3CT%3E.md), [`BinaryOperator<T>`](https://github.com/mnp014/Java/blob/master/Java8/Functional%20Interface%20/BinaryOperator%3CT%3E.md) | Special case of Function with same input & output types |

Note : All the above categories are not `Async` and `Non-Blocking`


----

[Function<T, R>](https://github.com/mnp014/Java/blob/master/Java8/Functional%20Interface%20/Function%3CT%2C%20R%3E.md)
```java
Function<Integer, String> intToString = i -> "Value: " + i;
System.out.println(intToString.apply(10)); // Value: 10
```
[Consumer<T>](https://github.com/mnp014/Java/blob/master/Java8/Functional%20Interface%20/Consumer%3CT%3E.md)
```java
Consumer<String> printer = msg -> System.out.println("Message: " + msg);
printer.accept("Hello!");
```
[Supplier<T>](https://github.com/mnp014/Java/blob/master/Java8/Functional%20Interface%20/Supplier%3CT%3E.md)
```java
Supplier<Double> randomSupplier = () -> Math.random();
System.out.println(randomSupplier.get()); // random double
```
[Predicate<T>](https://github.com/mnp014/Java/blob/master/Java8/Functional%20Interface%20/Predicate%3CT%3E.md)
```java
Predicate<String> isNotEmpty = str -> !str.isEmpty();
System.out.println(isNotEmpty.test("Test")); // true
```
[BiConsumer<T, U>](https://github.com/mnp014/Java/blob/master/Java8/Functional%20Interface%20/BiConsumer%3CT%2C%20U%3E.md)
```java
BiConsumer<String, Integer> mapAdder = (k, v) -> map.put(k, v);
mapAdder.accept("age", 25); // adds "age" → 25 to map
```
[UnaryOperator<T>](https://github.com/mnp014/Java/blob/master/Java8/Functional%20Interface%20/UnaryOperator%3CT%3E.md)
```java
UnaryOperator<String> toUpper = str -> str.toUpperCase();
System.out.println(toUpper.apply("hello")); // Output: HELLO
```
[BinaryOperator<T>](https://github.com/mnp014/Java/blob/master/Java8/Functional%20Interface%20/BinaryOperator%3CT%3E.md)
```java
BinaryOperator<Integer> max = (a, b) -> a > b ? a : b;
System.out.println(max.apply(5, 10)); // Output: 10
```


