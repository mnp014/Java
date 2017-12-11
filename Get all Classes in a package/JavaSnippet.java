 Reflections reflections = new Reflections("my.project.prefix");

 Set<Class<? extends Object>> allClasses = 
     reflections.getSubTypesOf(Object.class);
     
     
     
     
_____________________________________________________________________________________________________

A typical use of Reflections would be:
-----------------------------------------------------------------------------------------------------
Reflections reflections = new Reflections("my.project");

Set<Class<? extends SomeType>> subTypes = reflections.getSubTypesOf(SomeType.class);

Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(SomeAnnotation.class);
_____________________________________________________________________________________________________

Usage

Basically, to use Reflections first instantiate it with urls and scanners

//scan urls that contain 'my.package', include inputs starting with 'my.package', use the default scanners
Reflections reflections = new Reflections("my.package");

//or using ConfigurationBuilder
new Reflections(new ConfigurationBuilder()
     .setUrls(ClasspathHelper.forPackage("my.project.prefix"))
     .setScanners(new SubTypesScanner(), 
                  new TypeAnnotationsScanner().filterResultsBy(optionalFilter), ...),
     .filterInputsBy(new FilterBuilder().includePackage("my.project.prefix"))
     ...);
Then use the convenient query methods: (depending on the scanners configured)

//SubTypesScanner
Set<Class<? extends Module>> modules = 
    reflections.getSubTypesOf(com.google.inject.Module.class);
//TypeAnnotationsScanner 
Set<Class<?>> singletons = 
    reflections.getTypesAnnotatedWith(javax.inject.Singleton.class);
//ResourcesScanner
Set<String> properties = 
    reflections.getResources(Pattern.compile(".*\\.properties"));
//MethodAnnotationsScanner
Set<Method> resources =
    reflections.getMethodsAnnotatedWith(javax.ws.rs.Path.class);
Set<Constructor> injectables = 
    reflections.getConstructorsAnnotatedWith(javax.inject.Inject.class);
//FieldAnnotationsScanner
Set<Field> ids = 
    reflections.getFieldsAnnotatedWith(javax.persistence.Id.class);
//MethodParameterScanner
Set<Method> someMethods =
    reflections.getMethodsMatchParams(long.class, int.class);
Set<Method> voidMethods =
    reflections.getMethodsReturn(void.class);
Set<Method> pathParamMethods =
    reflections.getMethodsWithAnyParamAnnotated(PathParam.class);
//MethodParameterNamesScanner
List<String> parameterNames = 
    reflections.getMethodParamNames(Method.class)
//MemberUsageScanner
Set<Member> usages = 
    reflections.getMethodUsages(Method.class)
If no scanners are configured, the default will be used - SubTypesScanner and TypeAnnotationsScanner.
Classloader can also be configured, which will be used for resolving runtime classes from names.
Reflections expands super types by default. This solves some problems with transitive urls are not scanned.
Checkout the javadoc for more info.

Also, browse the tests directory to see some more examples.

ReflectionUtils

ReflectionsUtils contains some convenient Java reflection helper methods for getting types/constructors/methods/fields/annotations matching some predicates, generally in the form of *getAllXXX(type, withYYY)

for example:

import static org.reflections.ReflectionUtils.*;

Set<Method> getters = getAllMethods(someClass,
  withModifier(Modifier.PUBLIC), withPrefix("get"), withParametersCount(0));

//or
Set<Method> listMethodsFromCollectionToBoolean = 
  getAllMethods(List.class,
    withParametersAssignableTo(Collection.class), withReturnType(boolean.class));

Set<Field> fields = getAllFields(SomeClass.class, withAnnotation(annotation), withTypeAssignableTo(type));
See more in the ReflectionUtils javadoc

Integrating into your build lifecycle

Although scanning can be easily done on bootstrap time of your application - and shouldn't take long, it is sometime a good idea to integrate Reflections into your build lifecyle. With simple Maven/Gradle/SBT/whatever configuration you can save all scanned metadata into xml/json files just after compile time. Later on, when your project is bootstrapping you can let Reflections collect all those resources and re-create that metadata for you, making it available at runtime without re-scanning the classpath - thus reducing the bootstrapping time.

For Maven, see example using gmavenplus in the reflections-maven repository
