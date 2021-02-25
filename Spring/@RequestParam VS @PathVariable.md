#### 1. Overview  
The differences between Spring's `@RequestParam` and `@PathVariable` annotations.  
`@RequestParam` and `@PathVariable` can both be used to extract values from the request URI, but they are a bit different.

#### 2. Query Parameter vs URI Path  
While `@RequestParams` extract values from the query string, `@PathVariables` extract values from the URI path:
```
@GetMapping("/foos/{id}")
@ResponseBody
public String getFooById(@PathVariable String id) {
    return "ID: " + id;
}
```
Then, we can map based on the path:
```
http://localhost:8080/foos/abc
----
ID: abc
```
And for @RequestParam, it will be:
```
@GetMapping("/foos")
@ResponseBody
public String getFooByIdUsingQueryParam(@RequestParam String id) {
    return "ID: " + id;
}
```
Which would give us the same response, just a different URI:
```
http://localhost:8080/foos?id=abc
----
ID: abc
```
#### 3. Encoded vs Exact Value  
Because @PathVariable is extracting values from the URI path, it’s not encoded. On the other hand, @RequestParam is.

Using the previous example, ab+c will return as-is:
```
http://localhost:8080/foos/ab+c
----
ID: ab+c
```
But for a @RequestParam request, the parameter is URL decoded:
```
http://localhost:8080/foos?id=ab+c
----
ID: ab c
```
#### 4. Optional Values  
Both `@RequestParam` and `@PathVariable` can be optional.

We can make @PathVariable optional by using the required attribute starting with Spring 4.3.3:
```
@GetMapping({"/myfoos/optional", "/myfoos/optional/{id}"})
@ResponseBody
public String getFooByOptionalId(@PathVariable(required = false) String id){
    return "ID: " + id;
}
```
Which, then, we can do either:
```
http://localhost:8080/myfoos/optional/abc
----
ID: abc
```
or:
```
http://localhost:8080/myfoos/optional
----
ID: null
```
For `@RequestParam`, we can also use the required attribute.

#### [Note that we should be careful when making `@PathVariable` optional, to avoid conflicts in paths.]


