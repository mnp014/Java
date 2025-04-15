#### What is Loose Coupling?    
`Loose Coupling is a core principle in software design where components or classes are independent of each other, minimizing direct dependencies. In a loosely coupled system, changes in one component have minimal impact on others.`  

💡Simple Definition:  
`Loose coupling means that objects are connected, but know little about each other.  `

💡Example in Real Life:  
- A TV remote controls the TV, but it doesn’t know how the TV works internally.  
- You can change the TV model from same manufacturer, and the remote might still work (assuming basic compatibility).  

🧠 Why Loose Coupling Matters:  
  ✅ Easier to maintain and test  
  ✅ Reusable components  
  ✅ Improves flexibility and scalability  
  ✅ Reduces ripple effects from changes  

    
💡Loose Coupling in Spring:  
Spring achieves loose coupling using Dependency Injection (DI).  
Example:  
▶️ Without DI (Tightly Coupled)  
```java
public class Car {
    private Engine engine = new Engine(); // direct dependency
}
```
▶️ With DI (Loosely Coupled)
```java
public class Car {
    private final Engine engine;

    public Car(Engine engine) { // dependency injected
        this.engine = engine;
    }
}
```
 ⮞ `Car` doesn’t create an `Engine`. It just uses one that’s injected.  
 ⮞ Now you can easily inject a `PetrolEngine`, `DieselEngine`, or even a mock in tests.

     
💡Key Techniques to Achieve Loose Coupling:  
  ✅ Interfaces + Implementations  
  ✅ Dependency Injection (DI)  
  ✅ Event-driven communication  
  ✅ Service abstraction layers  
  ✅ Inversion of Control (IoC)  

---
#### What is a Dependency?    
`A dependency in software development is anything that a piece of code (like a class, function, or module) relies on to work properly.`  

💡Simple Definition:  
`A dependency is another object or service that a class needs to function.`  

Example:  
```java
public class Car {
    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }
}
```
Here:  
⮞ Car depends on Engine.  
⮞ So, Engine is a dependency of Car.  

🧠 Why Dependencies Matter:  
  ✅ They enable modular design — one class uses another without duplicating functionality.  
  ✅ But too many or hardcoded dependencies lead to tight coupling, making code hard to test or modify.  

💡Managing Dependencies:  
⮞ `Manually`: Creating and passing them yourself.  
⮞ Using `Dependency Injection (DI)`: Letting a `framework` like Spring manage and inject them.  
⮞ Using `Dependency Managers`: Like `Maven` or `Gradle`, which fetch libraries (external dependencies) your app needs.  

🗂️ Types of Dependencies:    
| Type         | Example                                      |
|--------------|----------------------------------------------|
| Internal     | Classes/objects within the app               |
| External     | Libraries like Apache Commons, Gson          |
| Runtime      | A database, file system, or service          |
| Compile-time | Other classes used directly in code          |

---
#### What is IOC (Inversion of Control)?    
`Inversion of Control (IoC) is a design principle where the control of creating and managing objects is transferred from your application code to a container or framework (like Spring).`

💡Simple Definition:  
`Instead of your code calling the library/framework, the framework calls your code and injects dependencies as needed.`

💡Example:  
▶️ In Traditional Code (No IoC):  
```java
public class Car {
    Engine engine = new Engine(); // You control object creation
}
```
Here, `Car` is responsible for creating its own `Engine` — this is tight coupling.  

▶️ With IoC in Spring:  
```java
@Component
public class Car {
    private final Engine engine;

    @Autowired
    public Car(Engine engine) { // Spring injects this
        this.engine = engine;
    }
}
```
⮞ Spring inverts the control: it creates the `Engine` and injects it into `Car`.  

💡 How Spring Implements IoC:  
Spring uses:  
  ✅ `IoC Container`: Like ApplicationContext  
  ✅ `Dependency Injection (DI)`: Constructor, setter, or field injection  
  ✅ `Bean lifecycle management`: Spring creates, configures, and manages beans  

 🎯 Benefits of IoC:  
➡️ Loose Coupling  
➡️ Easier Unit Testing  
➡️ Better Modular Code  
➡️ Simplifies Dependency Management  

📦 Real-world Analogy:  
Imagine a plug-in socket system:  
⮞ `Without IoC`: Your appliance must generate its own power.  
⮞ `With IoC`: The power comes from the wall (external source), and the appliance just plugs in.  


---
#### What is Dependency Injection?    
Dependency Injection (DI) is a `design pattern` and core part of Spring’s `Inversion of Control (IoC)` that lets you provide dependencies (like objects or services) to a class from the outside, rather than the class creating them itself.  

💡Simple Definition:   
`Instead of creating its own dependencies, a class receives them (injected) from an external source — usually a framework like Spring.`  

▶️ Without DI (Tightly Coupled):  
```java
public class Car {
    private Engine engine = new Engine(); // Car creates its own dependency
}
```
`Car` is tightly coupled to `Engine`. Hard to test, replace, or reuse.  
▶️ With DI (Loosely Coupled):  
```java
public class Car {
    private Engine engine;

    public Car(Engine engine) { // dependency is injected
        this.engine = engine;
    }
}
```
Now the `Car` doesn’t care how the `Engine` is made. It just uses what it’s given.

💡Spring makes DI easy:  
```java
@Component
public class Engine {}

@Component
public class Car {
    private final Engine engine;

    @Autowired
    public Car(Engine engine) {
        this.engine = engine;
    }
}
```

⮞ Spring scans `@Component` classes  
⮞ Creates the `Engine` bean  
⮞ Injects it into the `Car` bean automatically  

🗂️ Types of Dependency Injection:
| Type           | Example / Notes                                                                 |
|----------------|----------------------------------------------------------------------------------|
| Constructor DI | ✅ Recommended for immutability and required dependencies                        |
| Setter DI      | Useful for optional dependencies                                                 |
| Field DI       | Quick and easy, but harder to test (not recommended for complex apps)           |


🧠 Why DI is Awesome:  
  ✅ Promotes loose coupling  
  ✅ Improves testability (easy to inject mocks/stubs)  
  ✅ Makes code more flexible and maintainable  
  ✅ Centralizes object creation (managed by Spring container)  

---
#### Can you give few examples of Dependency Injection?    
---
#### What is Auto Wiring?    
---
#### What are the important roles of an IOC Container?    
---
#### What are Bean Factory and Application Context?    
---
#### Can you compare Bean Factory with Application Context?    
| Feature                   | `BeanFactory`                                                                 | `ApplicationContext`                                                            |
|---------------------------|-------------------------------------------------------------------------------|----------------------------------------------------------------------------------|
| Definition                | Basic container for managing beans in Spring                                 | More advanced container with additional enterprise features                     |
| Package                   | `org.springframework.beans.factory.BeanFactory`                              | `org.springframework.context.ApplicationContext`                                |
| Eager vs Lazy Loading     | Beans are lazily loaded (created when requested)                             | Beans are eagerly loaded by default (created at startup)                        |
| Internationalization (i18n) | Not supported                                                              | Supported (via `MessageSource`)                                                 |
| Event Propagation         | Not supported                                                                 | Supports publishing and listening to events                                     |
| Bean Post Processors      | Manual registration required                                                  | Automatically detects and registers them                                        |
| Context Aware Beans       | Manual setup required                                                         | Automatically injects application context into aware beans                      |
| Web Support               | Not supported                                                                 | Built-in support for web applications                                           |
| Preferred Usage           | Lightweight applications or for testing                                       | Enterprise-level applications (commonly used)                                   |
| Common Implementations    | `XmlBeanFactory` (now deprecated)                                             | `ClassPathXmlApplicationContext`, `AnnotationConfigApplicationContext`, etc.    |
| Dependency Injection      | Yes                                                                            | Yes                                                     

Sumary:|
- BeanFactory is the bare minimum, suitable for simple scenarios or unit tests.  
- ApplicationContext is a superset, providing more advanced features like:  
-- internationalization,  
-- event publishing,  
-- AOP integration,  
-- environment abstraction,  
-- convenient integration with Spring Boot.  
For most real-world applications, especially Spring Boot ones, ApplicationContext is preferred.  

---
#### How do you create an application context with Spring?    
 - You can create an ApplicationContext in Spring in multiple ways, depending on whether you're using XML-based, annotation-based, or Java-based configuration.  
   1. Using Annotation-based Configuration (Recommended for modern Spring apps)  
      ```java
      @Configuration
      @ComponentScan("com.example")
      public class AppConfig {
          // Bean definitions (if any)
      }

      // Create context
      ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
      MyBean myBean = context.getBean(MyBean.class);
      ```
      Make sure to annotate your classes with @Component, @Service, @Repository, or @Controller to be picked up by component scanning.
   2. Using XML-based Configuration
      ```xml
      <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xsi:schemaLocation="
              http://www.springframework.org/schema/beans
              http://www.springframework.org/schema/beans/spring-beans.xsd">

          <bean id="myBean" class="com.example.MyBean" />
      </beans>
      ```
      ```java
      ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
      MyBean myBean = (MyBean) context.getBean("myBean");
      ```
   3. Using Spring Boot (auto-configures ApplicationContext)
      ```java
      @SpringBootApplication
      public class MyApp {
          public static void main(String[] args) {
              ApplicationContext context = SpringApplication.run(MyApp.class, args);
              MyBean myBean = context.getBean(MyBean.class);
          }
      }
      ```
   4. Using GenericApplicationContext (manual control)
      ```java
      GenericApplicationContext context = new GenericApplicationContext();
      context.registerBean(MyBean.class);
      context.refresh();
      MyBean myBean = context.getBean(MyBean.class);
      ```
Make sure to annotate your classes with @Component, @Service, @Repository, or @Controller to be picked up by component scanning.  

---
#### How does Spring know where to search for Components or Beans?    
---
#### What is a Component Scan?    
---
#### How do you define a component scan in XML and Java Configurations?    
---
#### How is it done with Spring Boot?    
---
#### What does @Component signify?    
---
#### What does @Autowired signify?    
---
#### What’s the difference Between @Controller, @Component, @Repository, and @Service Annotations in Spring?    
---
#### What is the default scope of a bean?    
---
#### Are Spring beans thread safe?    
---
#### What are the other scopes available?    
---
#### How is Spring’s singleton bean different from Gang of Four Singleton Pattern?    
---
#### What are the different types of dependency injections?    
---
#### What is setter injection?    
---
#### What is constructor injection?    
---
#### How do you choose between setter and constructor injections?    
---
#### What are the different options available to create Application Contexts for Spring?  
---
#### What is the difference between XML and Java Configurations for Spring?  
---
#### How do you choose between XML and Java Configurations for Spring?  
---
#### How does Spring do Autowiring?  
Autowiring in Spring is how the framework automatically injects dependencies into a bean, without needing to explicitly specify them in configuration. It’s part of dependency injection (DI) and helps in reducing boilerplate code.

Spring uses reflection and the ApplicationContext to:
1. Scan and register beans (if component scanning is enabled).
2. Resolve dependencies by type (and optionally by name).
3. Inject the matching beans into dependent components during initialization.

Ways to Autowire in Spring
1. Using @Autowired Annotation
```java
   @Component
   public class Car {
      @Autowired
      private Engine engine;
   }
```

- Injects `Engine` bean into `Car`.
- Done by type (`Engine.class`).
- Can also be applied to constructors, setters, or fields.

 2. Constructor Injection (Recommended)
```java
    @Component
    public class Car {
        private final Engine engine;

        @Autowired
        public Car(Engine engine) {
            this.engine = engine;
        }
    }
```
- Immutable.
- Great for unit testing.
- Ensures dependencies are provided at creation time.
  
3.  Setter Injection
```java
@Component
public class Car {
    private Engine engine;

    @Autowired
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
```

4. Autowiring Modes in XML Config (Deprecated style)
```xml
   <bean id="car" class="com.example.Car" autowire="byType"/>
```
  
   Modes:  
    - `no` (default)  
    - `byName`  
    - `byType`  
    - `constructor`  
    - `autodetect` (deprecated)  

  
Internals (Behind the Scenes):  
 - During context startup, Spring scans for annotated classes if component scanning is used.  
 - Spring resolves all dependencies using the `BeanFactory`.  
 - The `AutowiredAnnotationBeanPostProcessor` is triggered, which:  
 -- Finds fields/methods/constructors with `@Autowired`.  
 -- Injects appropriate beans from the context.  
 - If multiple candidates exist, Spring uses:  
 -- `@Qualifier` to specify the exact one.  
 -- `@Primary` if one bean is marked as preferred.  
  
Common Gotchas:  
 - If multiple beans of the same type exist: you'll get NoUniqueBeanDefinitionException unless:  
 -- You use @Qualifier("beanName")  
 -- One bean is marked @Primary  
 - If no bean of required type exists and required=true (default), you'll get NoSuchBeanDefinitionException.  

---
#### What are the different kinds of matching used by Spring for Autowiring?    
---
#### How do you debug problems with Spring Framework?    
---
#### How do you solve NoUniqueBeanDefinitionException?    
---
#### How do you solve NoSuchBeanDefinitionException?    
---
#### What is @Primary?    
---
#### What is @Qualifier?    
---
#### What is CDI (Contexts and Dependency Injection)?    
---
#### Does Spring Support CDI?    
---
#### Would you recommed to use CDI or Spring Annotations?    
---
#### What are the major features in different versions of Spring?    
---
#### What are new features in Spring Framework 4.0?    
---
#### What are new features in Spring Framework 5.0?    
---
#### What are important Spring Modules?  
---
#### What are important Spring Projects?  
---
#### What is the simplest way of ensuring that we are using single version of all Spring related dependencies?  
---
#### Name some of the design patterns used in Spring Framework?  
---
#### What do you think about Spring Framework?  
---
#### Why is Spring Popular?  
---
#### Can you give a big picture of the Spring Framework?  
---  
