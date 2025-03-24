Following are the building blocks of Java 8+ features like:
1) Streams API
2) Lambdas
3) Method references
4) Reactive programming
5) Declarative pipelines

| Type      | Examples                             | Purpose                                      |
|-----------|--------------------------------------|----------------------------------------------|
| Function  | `Function<T,R>`, `BiFunction<T,U,R>` | Transform input to output                    |
| Consumer  | `Consumer<T>`, `BiConsumer<T,U>`     | Perform actions (void return)                |
| Supplier  | `Supplier<T>`                        | Provide/generate values                      |
| Predicate | `Predicate<T>`, `BiPredicate<T,U>`   | Test/evaluate boolean conditions             |
| Operator  | `UnaryOperator<T>`, `BinaryOperator<T>` | Special case of Function with same input/output types |

Note : All the above categories are not `Async` and `Non-Blocking`


----

Function<T, R>
```
Function<Integer, String> intToString = i -> "Value: " + i;
System.out.println(intToString.apply(10)); // Value: 10
```
Consumer<T>
```
Consumer<String> printer = msg -> System.out.println("Message: " + msg);
printer.accept("Hello!");
```
Supplier<T>
```
Supplier<Double> randomSupplier = () -> Math.random();
System.out.println(randomSupplier.get()); // random double
```
Predicate<T>
```
Predicate<String> isNotEmpty = str -> !str.isEmpty();
System.out.println(isNotEmpty.test("Test")); // true
```
BiConsumer<T, U>
```
BiConsumer<String, Integer> mapAdder = (k, v) -> map.put(k, v);
mapAdder.accept("age", 25); // adds "age" → 25 to map
```



