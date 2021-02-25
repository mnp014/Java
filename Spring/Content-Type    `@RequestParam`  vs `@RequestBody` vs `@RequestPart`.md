map HTTP request header Content-Type, handle request body.

`@RequestParam` ← `application/x-www-form-urlencoded`,  

`@RequestBody` ← `application/json`,
 
`@RequestPart` ← `multipart/form-data`,

---

#### RequestParam (Spring Framework 5.1.9.RELEASE API)  

map to query parameters, form data, and parts in multipart requests.  
`RequestParam` is likely to be used with name-value form fields

#### RequestBody (Spring Framework 5.1.9.RELEASE API)

bound to the body of the web request. The body of the request is passed through an `HttpMessageConverter` to resolve the method argument depending on the `content type` of the request. (e.g. JSON, XML)

#### RequestPart (Spring Framework 5.1.9.RELEASE API)  

used to associate the part of a `"multipart/form-data"` request  
`RequestPart` is likely to be used with parts containing more complex content

#### HttpMessageConverter (Spring Framework 5.1.9.RELEASE API)

a converter that can convert from and to HTTP requests and responses.  
All Known Implementing Classes: ..., `AbstractJsonHttpMessageConverter`, `AbstractXmlHttpMessageConverter`, ...


---

#### More Explanation:  

`@RequestParam` annotated parameters get linked to specific Servlet request parameters. Parameter values are converted to the declared method argument type. This annotation indicates that a method parameter should be bound to a web request parameter.  
For example Angular request for Spring RequestParam(s) would look like that:

```
$http.post('http://localhost:7777/scan/l/register?username="Johny"&password="123123"&auth=true')
      .success(function (data, status, headers, config) {
                        ...
                    })
```
Endpoint with RequestParam:

```
@RequestMapping(method = RequestMethod.POST, value = "/register")
public Map<String, String> register(Model uiModel,
                                    @RequestParam String username,
                                    @RequestParam String password,
                                    @RequestParam boolean auth,
                                    HttpServletRequest httpServletRequest) {...
 ```
 
 `@RequestBody` annotated parameters get linked to the HTTP request body. Parameter values are converted to the declared method argument type using HttpMessageConverters. This annotation indicates a method parameter should be bound to the body of the web request.

For example Angular request for Spring RequestBody would look like that:  
```
$scope.user = {
            username: "foo",
            auth: true,
            password: "bar"
        };    
$http.post('http://localhost:7777/scan/l/register', $scope.user).
                        success(function (data, status, headers, config) {
                            ...
                        })
```
Endpoint with RequestBody:  

```
@RequestMapping(method = RequestMethod.POST, produces = "application/json", 
                value = "/register")
public Map<String, String> register(Model uiModel,
                                    @RequestBody User user,
                                    HttpServletRequest httpServletRequest) {...
```                                    
                                    
