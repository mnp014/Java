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
✅ Example 1: Constructor Injection (Recommended)  
```java
@Component
public class Engine {
    public String start() {
        return "Engine started!";
    }
}

@Component
public class Car {
    private final Engine engine;

    @Autowired // Optional since Spring 4.3+ if there's only one constructor
    public Car(Engine engine) {
        this.engine = engine;
    }

    public void drive() {
        System.out.println(engine.start());
    }
}
```
✅ Example 2: Setter Injection  
```java
@Component
public class Car {
    private Engine engine;

    @Autowired
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void drive() {
        System.out.println(engine.start());
    }
}
```
✅ Example 3: Field Injection (Not recommended for unit testing)  
```java
@Component
public class Car {
    @Autowired
    private Engine engine;

    public void drive() {
        System.out.println(engine.start());
    }
}
```
✅ Example 4: Using `@Qualifier` with Multiple Beans
```java
@Component("dieselEngine")
public class DieselEngine implements Engine {
    public String start() {
        return "Diesel engine started!";
    }
}

@Component("petrolEngine")
public class PetrolEngine implements Engine {
    public String start() {
        return "Petrol engine started!";
    }
}

@Component
public class Car {
    private final Engine engine;

    @Autowired
    public Car(@Qualifier("petrolEngine") Engine engine) {
        this.engine = engine;
    }

    public void drive() {
        System.out.println(engine.start());
    }
}
```
✅ Example 5: Injecting External Dependency (e.g., from application.properties)
```properties
# application.properties
car.model=Toyota Supra
```
```java
@Component
public class Car {
    @Value("${car.model}")
    private String model;

    public void showModel() {
        System.out.println("Car model: " + model);
    }
}
```  
These examples demonstrate how Spring automatically injects dependencies and manages the lifecycle, helping you build loosely coupled, testable, and maintainable code.  


---
#### What is Auto Wiring?    
Autowiring is a feature in Spring that automatically injects dependencies into a Spring bean without explicitly specifying them in the configuration. Spring uses Dependency Injection (DI) to do this behind the scenes.

💡Simple Definition:   
`Autowiring is Spring’s way of saying,`  
`“Hey, I’ll figure out what this bean needs and provide it for you — no need to manually wire it.”`  

💡Example:
```java
@Component
public class Engine {
    public String start() {
        return "Engine started!";
    }
}

@Component
public class Car {
    @Autowired
    private Engine engine;

    public void drive() {
        System.out.println(engine.start());
    }
}
```
⮞ `@Autowired` tells Spring to inject an instance of `Engine` into the `Car`.  
⮞ You don't need to use `new Engine()` anywhere. Spring handles that.  

💡 How Spring Performs Autowiring:  
⮞ Scans for `@Component` beans using `@ComponentScan`  
⮞ `Creates` and `manages` the beans in the `ApplicationContext`  
⮞ Looks at `@Autowired` `fields`/`constructors`/`setters`  
⮞ Finds `matching beans` by type  
⮞ `Injects` them automatically  


🗂️ Types of Dependency Injection:  
| Type         | Description                                                                 |
|--------------|-----------------------------------------------------------------------------|
| `byType`     | Injects by matching type (e.g., `Engine`)                                   |
| `byName`     | Injects by matching bean name (used in XML config)                          |
| `constructor`| Injects via constructor if only one exists or marked with `@Autowired`      |
| `no`         | Default in XML config (no autowiring)                                       |
| `autodetect` | *(Deprecated)* Chooses between constructor and `byType` automatically       |


💡 Benefits of Autowiring:  
  ✅ Reduces boilerplate code  
  ✅ Promotes loose coupling  
  ✅ Enables easier unit testing  
  ✅ Keeps code clean and maintainable  
  
---
#### What are the important roles of an IOC Container?    
The IoC (Inversion of Control) Container is the core of the Spring Framework — it’s responsible for managing the lifecycle and configuration of application objects (beans).

📦 Important Roles of the IoC Container in Spring:  
| 🔢 | 📌 Role of IoC Container                       | 🔍 Description                                                                                   |
|----|------------------------------------------------|--------------------------------------------------------------------------------------------------|
| 1️⃣ | Bean Creation                                 | Instantiates and manages Java objects (beans).                                                  |
| 2️⃣ | Dependency Injection                          | Automatically injects required dependencies into beans (constructor/setter/field injection).     |
| 3️⃣ | Bean Configuration                            | Reads metadata (XML, annotations, or Java config) to configure beans.                            |
| 4️⃣ | Bean Lifecycle Management                     | Controls the full lifecycle: creation, initialization, destruction.                              |
| 5️⃣ | Scope Management                              | Manages bean scopes: singleton, prototype, request, session, etc.                                |
| 6️⃣ | Event Publication                             | Publishes and listens for events via `ApplicationEventPublisher`.                                |
| 7️⃣ | Resource Loading                              | Provides utilities to access resources (like `.properties` files).                               |
| 8️⃣ | AOP Support                                   | Creates proxies for beans to enable AOP (Aspect-Oriented Programming).                           |
| 9️⃣ | Internationalization (i18n)                   | Supports message resolution for multiple locales.                                                |
| 🔟 | Bean Post-Processors and Aware Interfaces      | Allows hooks before/after bean initialization and supports injecting context/environment directly into beans. |

📦 IoC Container Interfaces in Spring
| Interface          | Description                                                                 |
|--------------------|-----------------------------------------------------------------------------|
| `BeanFactory`       | Basic container; supports lazy loading and simple DI.                       |
| `ApplicationContext`| Advanced container; builds on `BeanFactory` and adds support for AOP, i18n, events, etc. |

Common implementations:  
⮞ `ClassPathXmlApplicationContext`  
⮞ `AnnotationConfigApplicationContext`  
⮞ `GenericApplicationContext` (more flexible)  

🔄 Lifecycle of a Bean in IoC Container:  
1️⃣⮞ Read Configuration (XML, annotations, or Java classes)  
2️⃣⮞ Instantiate Beans  
3️⃣⮞ Inject Dependencies  
4️⃣⮞ Call Aware Interfaces  
5️⃣⮞ Apply Bean PostProcessors  
6️⃣⮞ Call Initialization Methods  
7️⃣⮞ Bean is Ready for Use  
8️⃣⮞ Call Destroy Methods on Shutdown  

---
#### What are Bean Factory and Application Context?   
🏭 1. BeanFactory   
`BeanFactory` is the most basic Spring IoC container. It provides the fundamental features for managing beans, such as:  
| Aspect             | Description                                                                 |
|--------------------|-----------------------------------------------------------------------------|
| 📦 Interface        | `org.springframework.beans.factory.BeanFactory`                             |
| 🎯 Primary Feature  | Lazy-loading of beans (created only when needed)                            |
| 🔧 Configuration    | XML-based or manual                                                         |
| ⚙️ Use Case         | Lightweight applications, testing, or memory-sensitive apps                 |
| ❌ Limitations      | No support for advanced features like AOP, events, or i18n                  |

💡  Example (Old Style):  
```java
BeanFactory factory = new XmlBeanFactory(new FileSystemResource("beans.xml"));
MyBean myBean = factory.getBean("myBean", MyBean.class);
```
🔻 `XmlBeanFactory` is deprecated — replaced by ApplicationContext.

🌐 2. ApplicationContext  
`ApplicationContext` is the more powerful and preferred container in Spring. It extends BeanFactory and provides many enterprise-level features.  
| Aspect                  | Description                                                        |
|-------------------------|--------------------------------------------------------------------|
| 📦 Interface            | `org.springframework.context.ApplicationContext`                   |
| ⚙️ Features              | Everything `BeanFactory` offers plus:                              |
| ✅ AOP Support          | Yes                                                                |
| ✅ Event Publishing     | Yes (`ApplicationEventPublisher`)                                  |
| ✅ i18n Support         | Yes                                                                |
| ✅ Bean PostProcessors  | Auto-detected                                                      |
| ✅ Environment Abstraction | Yes                                                            |
| ✅ Eager Loading        | Beans are created at startup (by default)                          |

💡 Example (Modern Usage):  
```java
ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
MyBean myBean = context.getBean(MyBean.class);
```
Or, using annotations:  
```java
ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
```
💡 Key Differences Summary:  
| Feature                   | `BeanFactory`             | `ApplicationContext`           |
|---------------------------|---------------------------|---------------------------------|
| Bean Instantiation        | Lazy (on demand)          | Eager (at startup)              |
| Event Handling            | ❌ Not supported           | ✅ Supported                    |
| AOP Integration           | ❌ Manual                  | ✅ Automatic                    |
| MessageSource (i18n)      | ❌ Not supported           | ✅ Supported                    |
| Bean Post Processors      | ❌ Manual registration     | ✅ Auto-detected                |
| Web Application Support   | ❌ Limited                 | ✅ Full support                 |

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
✅ 1. Using @ComponentScan Annotation (Java Config)  
In annotation-based configuration, Spring uses @ComponentScan to specify the base packages it should scan for beans.  
```java
@Configuration
@ComponentScan(basePackages = "com.example.myapp")
public class AppConfig {
}
```
⮞ Spring will scan the package com.example.myapp and all its sub-packages for annotated components.  
⮞ Without explicitly specifying, it scans the package of the configuration class by default.  

✅ 2. Using @SpringBootApplication (Spring Boot)  
If you're using Spring Boot, the main class has:  
```java
@SpringBootApplication
public class MyApp {
    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }
}
```
⮞ `@SpringBootApplication` includes `@ComponentScan` by default:  
```java
@ComponentScan(basePackages = "com.example") // implicit
```
So Spring will scan the package of this class and its sub-packages.  
🟦 `Best practice`: Put your main class in the root package to scan everything below.  

✅ 3. Using XML Configuration (Old Style)  
```xml
<context:component-scan base-package="com.example.myapp"/>
```
⮞ This tells Spring to scan that package for beans.

🔍 What is Spring looking for?  
⮞ Spring scans for classes annotated with:  
| Annotation       | Purpose                                               |
|------------------|-------------------------------------------------------|
| `@Component`     | Generic Spring-managed bean                           |
| `@Service`       | Business logic service class                          |
| `@Repository`    | DAO layer bean (with exception translation)           |
| `@Controller`    | MVC controller                                        |
| `@RestController`| REST API controller                                   |
⮞ All of the above are detected during component scanning.  

📦 TL;DR:
Spring knows where to look because of `@ComponentScan` or `@SpringBootApplication`. It scans the `specified package` and its `sub-packages` for `annotated beans`.  


---
#### What is a Component Scan?    
#### How do you define a component scan in XML and Java Configurations?    
#### How is it done with Spring Boot?    

Component Scan is a Spring feature that automatically detects and registers beans (classes annotated with @Component, @Service, @Repository, or @Controller) into the Spring IoC container at runtime — so you don’t have to define each bean manually.

💡Simple Definition:  
`Component Scan tells Spring:`  
`“Hey, go look inside this package and find any classes that should be turned into beans.”`  

💡How it Works  
When Spring starts up:  
1️⃣⮞ It reads your configuration (@Configuration, @SpringBootApplication, or XML).  
2️⃣⮞ It looks at the @ComponentScan directive.  
3️⃣⮞ It scans the specified packages and subpackages.  
4️⃣⮞ Finds classes with bean-related annotations.  
5️⃣⮞ Registers them as Spring-managed beans.  

 Common Annotations Detected During Component Scanning  
| Annotation        | Purpose                                           |
|-------------------|---------------------------------------------------|
| `@Component`      | Generic component                                 |
| `@Service`        | Business logic layer                              |
| `@Repository`     | Data access layer (with exception translation)    |
| `@Controller`     | MVC controller                                    |
| `@RestController` | REST controller                                   |
All of these are just stereotypes of `@Component`, so Spring can pick them up.  

💡Where to Declare Component Scanning?   
✅ Java-based Configuration:    
```java
@Configuration
@ComponentScan(basePackages = "com.example.myapp")
public class AppConfig {
}
```

✅ Spring Boot (Auto Component Scan):  
```java
@SpringBootApplication
public class MyApp {
    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }
}
```
⮞ `@SpringBootApplication` includes `@ComponentScan` automatically.  
⮞ It scans the package where this class is defined and all its sub-packages.  

✅ XML Configuration:  
```xml
<context:component-scan base-package="com.example.myapp"/>
```
💡 Best Practices  
⮞ Keep your main application class in the root package.  
⮞ Keep related components grouped logically in sub-packages.  
⮞ Use specific `basePackages` if you want tighter control over what gets scanned.  

💡 Example:  
```java
// Scanned automatically
@Component
public class Engine {
    public void start() {
        System.out.println("Engine started!");
    }
}
```
```java
@Component
public class Car {
    @Autowired
    private Engine engine;

    public void drive() {
        engine.start();
    }
}
```
⮞ As long as both are in a scanned package, you don’t need to define them manually in any config.  


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
