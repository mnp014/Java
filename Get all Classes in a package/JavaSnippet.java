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
