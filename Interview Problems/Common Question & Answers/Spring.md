#### What is Loose Coupling?    
---
#### What is a Dependency?    
---
#### What is IOC (Inversion of Control)?    
---
#### What is Dependency Injection?    
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
