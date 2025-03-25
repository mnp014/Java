## 🔄 Intermediate Operators
These return a new Stream and can be chained.

✅ Applicable for All Stream Types (Stream\<T>, IntStream, LongStream, DoubleStream)

| Operator                      | Description                                                                 |
|-------------------------------|-----------------------------------------------------------------------------|
| `filter(Predicate)`           | Filters elements that match a predicate                                     |
| `map(Function)`               | Transforms each element using the provided function                         |
| `flatMap(Function)`           | Flattens nested streams into a single stream                                |
| `distinct()`                  | Removes duplicate elements from the stream                                 |
| `sorted()`                    | Sorts elements in natural order                                            |
| `sorted(Comparator)`          | Sorts elements using a custom comparator                                   |
| `peek(Consumer)`              | Performs an action on each element as it is consumed                        |
| `limit(long)`                 | Truncates the stream to a given size                                       |
| `skip(long)`                  | Skips the first n elements of the stream                                   |
| `takeWhile(Predicate)`        | Takes elements while the predicate is true (Java 9+)                        |
| `dropWhile(Predicate)`        | Drops elements while predicate is true, returns rest (Java 9+)              |

🔸Applicable Only for Object Streams (Stream\<T>)

| Operator                         | Description                                                                  |
|----------------------------------|------------------------------------------------------------------------------|
| `mapToInt(ToIntFunction)`        | Maps elements to an `IntStream`                                              |
| `mapToLong(ToLongFunction)`      | Maps elements to a `LongStream`                                              |
| `mapToDouble(ToDoubleFunction)`  | Maps elements to a `DoubleStream`                                            |
| `flatMapToInt(Function)`         | Flattens nested `IntStream`s                                                 |
| `flatMapToLong(Function)`        | Flattens nested `LongStream`s                                                |
| `flatMapToDouble(Function)`      | Flattens nested `DoubleStream`s                                              |
| `mapMulti(BiConsumer)`           | Maps each element to multiple elements using a consumer                      |
| `mapMultiToInt(BiConsumer)`      | Like `mapMulti` but returns an `IntStream`                                   |
| `mapMultiToLong(BiConsumer)`     | Like `mapMulti` but returns a `LongStream`                                   |
| `mapMultiToDouble(BiConsumer)`   | Like `mapMulti` but returns a `DoubleStream`                                 |

➡ Total Intermediate Operators: 21

---

## 🛑 Terminal Operators
These consume the stream and produce a result or side-effect.

✅ Applicable for All Stream Types (Stream\<T>, IntStream, LongStream, DoubleStream)

| Operator              | Description                                                  |
|-----------------------|--------------------------------------------------------------|
| `forEach(Consumer)`   | Performs an action for each element                          |
| `toArray()`           | Collects elements into an Object array                       |
| `count()`             | Returns the count of elements                                |
| `anyMatch(Predicate)` | Checks if any elements match the predicate                   |
| `allMatch(Predicate)` | Checks if all elements match the predicate                   |
| `noneMatch(Predicate)`| Checks if no elements match the predicate                    |

🔸Applicable Only for Object Streams (Stream\<T>)

| Operator                                                  | Description                                                               |
|-----------------------------------------------------------|---------------------------------------------------------------------------|
| `forEachOrdered(Consumer)`                                | Like `forEach` but maintains encounter order                              |
| `toArray(IntFunction<A[]>)`                               | Collects elements into a typed array                                      |
| `reduce(BinaryOperator)`                                  | Reduces elements to one using a binary operator                           |
| `reduce(T, BinaryOperator)`                               | Performs a reduction starting with an identity value                      |
| `reduce(U, BiFunction, BinaryOperator)`                   | Reduces with a mapping function and combiner                              |
| `gather(Gatherer)`                                        | Gathers elements into a new Stream (Java 21+)                             |
| `collect(Supplier, BiConsumer, BiConsumer)`               | Mutable reduction with explicit supplier/accumulator/combinator           |
| `collect(Collector)`                                      | Performs a mutable reduction using a `Collector`                          |
| `toList()`                                                | Collects elements into a `List` (Java 16+)                                |
| `min(Comparator)`                                         | Finds the minimum element                                                 |
| `max(Comparator)`                                         | Finds the maximum element                                                 |
| `findFirst()`                                             | Returns the first element (if any)                                        |
| `findAny()`                                               | Returns any element (may be faster with parallel streams)                 |

➡ Total Terminal Operators: 19

---

## 🏗️ Static Methods (Stream Source Methods)
These aren’t intermediate or terminal—they create streams.

✅ Applicable for All Stream Types (Stream\<T>, IntStream, LongStream, DoubleStream)

| Operator               | Description                                                  |
|------------------------|--------------------------------------------------------------|
| `empty()`              | Returns an empty sequential stream                            |
| `generate(Supplier)`   | Generates an infinite stream using a Supplier                 |
| `concat(Stream, Stream)`| Concatenates two streams into one                            |

🔸Applicable Only for Object Streams (Stream\<T>)

| Operator                                 | Description                                                         |
|------------------------------------------|---------------------------------------------------------------------|
| `builder()`                              | Creates a mutable stream builder for manually adding elements       |
| `of(T)`                                  | Creates a stream containing a single element                        |
| `ofNullable(T)`                          | Creates a stream with 0 or 1 element depending on nullability       |
| `of(T...)`                               | Creates a stream from multiple values                               |
| `iterate(T, UnaryOperator)`              | Generates an infinite stream by repeatedly applying a function      |
| `iterate(T, Predicate, UnaryOperator)`   | Generates a stream with condition and iteration (Java 9+)           |

➡ Total Stream Creators: 9
