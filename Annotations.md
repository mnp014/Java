```
import java.lang.annotation.*;

@Inherited
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface BikeAnnotation {
    int wheelCount() default 2;
    String model() default "unknown";
}

@BikeAnnotation(wheelCount = 3, model = "NewBike")
class Bike {

    String owner;

    public Bike(String owner) {
        this.owner = owner;
    }

    public void show() {
        System.out.println("in class Bike");
    }
}

@BikeAnnotation(model = "Ninja300")
class Kawasaki extends Bike {
    public Kawasaki(String owner) {
        super(owner);
    }

    public void show() {
        System.out.println("in class kawasaki");
    }
}

class Scratch {
    public static void main(String[] args) {
        Bike bike = new Bike("new Owner");
        Class clazz = bike.getClass();
        Annotation annotation = clazz.getAnnotation(BikeAnnotation.class);
        BikeAnnotation bikeAnnotation = (BikeAnnotation) annotation;
        System.out.println(bikeAnnotation.wheelCount());
        System.out.println(bikeAnnotation.model());


        /*
         * Demo @Inherited annotation
         */
        Kawasaki kawasaki = new Kawasaki("new Owner");
        Class clazz1 = kawasaki.getClass();
        Annotation annotation1 = clazz1.getAnnotation(BikeAnnotation.class);
        BikeAnnotation bikeAnnotation1 = (BikeAnnotation) annotation1;
        System.out.println(bikeAnnotation1.wheelCount());
        System.out.println(bikeAnnotation1.model());

    }
}
```
____

#### Step 1:
Create an annotation.
annotation can be a `marker annotation`, `single-value annotation` or `multivalued annotations`

Example:
 - Marker annotation:
 ```
        @interface BikeAnnotation {
         }
 ```
 - single-value annotation
 ```
        @interface BikeAnnotation {
           int wheelCount() default 2;
        }
 ```
 - `multivalued annotations`
 ```
        @interface BikeAnnotation {
           int wheelCount() default 2;
           String model() default "unknown";
        }
 ```
 
 #### Step 2:
 Use the annotation on target 
 
 Example:
 ```
        @BikeAnnotation(wheelCount = 3, model = "NewBike")
        class Bike {
               ...
        }

 ```
 
 #### Step 3:
 Access annotation:
 ```
        Bike bike = new Bike("new Owner");
        Class clazz = bike.getClass();
        Annotation annotation = clazz.getAnnotation(BikeAnnotation.class);
        BikeAnnotation bikeAnnotation = (BikeAnnotation) annotation;
        System.out.println(bikeAnnotation.wheelCount());
        System.out.println(bikeAnnotation.model());

 ```
 #### NOTE:   
  - `@Target` and `@Retention` are must to be declared for annotations to work.  
  - `@Documented` can be declared for java documentations.  
  - `@Inherited` can be declared to apply annotations on the inhereited class objects.  
  Example:
  ```
        @BikeAnnotation(model = "Ninja300")
        class Kawasaki extends Bike {
            public Kawasaki(String owner) {
            super(owner);
            }
        }
  
  // and accessing the same.
  
        class Scratch {
            Kawasaki kawasaki = new Kawasaki("new Owner");
            Class clazz1 = kawasaki.getClass();
            Annotation annotation1 = clazz1.getAnnotation(BikeAnnotation.class);
            BikeAnnotation bikeAnnotation1 = (BikeAnnotation) annotation1;
            System.out.println(bikeAnnotation1.wheelCount());
            System.out.println(bikeAnnotation1.model());
        }
  ```

