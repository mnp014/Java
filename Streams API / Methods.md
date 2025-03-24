### Intermediate Stream Operators in Java:

1) Applicable to All Stream Types (`Stream`, `IntStream`, `LongStream`, `DoubleStream`)
   
| Operator                        | Description                                                                                 | 
|----------------------------------|---------------------------------------------------------------------------------------------|
| `filter(Predicate)`             | Filters elements that match a predicate                                                     | 
| `map(Function)`                 | Transforms each element using the provided function                                         |
| `flatMap(Function)`             | Flattens nested streams into a single stream                                               | 
| `limit(long)`                   | Truncates the stream to a given size                                                       | 
| `skip(long)`                    | Skips the first n elements of the stream                                                   | 
| `takeWhile(Predicate)`          | Takes elements while the predicate is true (Java 9+)                                       | 
| `dropWhile(Predicate)`          | Drops elements while the predicate is true, then returns the rest (Java 9+)                | 
| `parallel()`                    | Converts the stream into a parallel stream                                                 | 
| `sequential()`                  | Converts a parallel stream back into a sequential stream                                   | 

2) These are only available on `Stream<T`> (not on primitive streams)
   
| Operator                        | Description                                                                                 |
|----------------------------------|---------------------------------------------------------------------------------------------|
| `mapToInt(ToIntFunction)`       | Converts object stream to `IntStream`                                                      | 
| `mapToLong(ToLongFunction)`     | Converts object stream to `LongStream`                                                     | 
| `mapToDouble(ToDoubleFunction)` | Converts object stream to `DoubleStream`                                                   | 
| `flatMapToInt(Function)`        | Flattens into `IntStream` from each element                                                | 
| `flatMapToLong(Function)`       | Flattens into `LongStream` from each element                                               | 
| `flatMapToDouble(Function)`     | Flattens into `DoubleStream` from each element                                             | 
| `distinct()`                    | Removes duplicate elements                                                                 | 
| `sorted()`                      | Sorts elements in natural order                                                            | 
| `sorted(Comparator)`            | Sorts elements using a custom comparator                                                   |  
| `peek(Consumer)`                | Performs an action on each element (commonly for debugging/logging)                        |  
| `unordered()`                   | Hints that stream elements do not need to be ordered (may improve performance)             | 
| `onClose(Runnable)`             | Registers a close handler (useful for cleaning up resources when stream is closed)         |  

3) available on all primitive streams to convert to Stream<T>

| Operator                        | Description                                                                                 |
|----------------------------------|---------------------------------------------------------------------------------------------|
| `boxed()`                       | Converts a primitive stream (`IntStream`, `LongStream`, `DoubleStream`) into object stream |

-----

### Terminal Stream Operators in Java:

1) Applicable to All Stream Types (`Stream<T>`)
   
| Terminal Operator         | Description                                                              |
|---------------------------|--------------------------------------------------------------------------|
| `forEach(Consumer)`       | Performs an action for each element                                      |
| `forEachOrdered(Consumer)`|	Preserves encounter order (esp. for parallel streams)                    |
| `toArray()`               | Returns an array containing the elements                                 |
| `reduce()`                | Reduces elements to a single value using an accumulator                  |
| `collect()`               | Gathers elements into a collection (e.g. List, Set, Map)                 |
| `min(Comparator)`         | Finds the minimum element                                                |
| `max(Comparator)`         | Finds the maximum element                                                |
| `count()`                 | Returns the number of elements                                           |
| `anyMatch(Predicate)`     | Returns true if any element matches the predicate                        |
| `allMatch(Predicate)`     | Returns true if all elements match the predicate                         |
| `noneMatch(Predicate)`    | Returns true if no elements match the predicate                          |
| `findFirst()`             | Returns the first element (as Optional)                                  |
| `findAny()`               | Returns any element (non-deterministic in parallel streams)              |

2) Applicable to Primitive streams (`IntStream`, `LongStream`, `DoubleStream`) for computing numeric statistics:
   
| Terminal Operator        | Description                                                              |
|--------------------------|--------------------------------------------------------------------------|
| `sum()`                  | Returns sum of elements                                                  |
| `average()`              | Returns average as `OptionalDouble`                                      |
| `summaryStatistics()`    | Returns count, sum, min, max, avg in a stats obj                         |

-----
