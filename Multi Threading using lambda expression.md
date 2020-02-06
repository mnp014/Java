#### Multiple threads using lambda expression
```
        Thread t1 = new Thread(() -> {
            //logic 1
        });
        Thread t2 = new Thread(() -> {
            //logic 2
        });
        Thread t3 = new Thread(() -> {
            //logic 3
        });
        t1.start();
        t2.start();
        t3.start();
```


___
## Derivation

#### Using seperate class
```
class C1 implements Runnable{
        public void run() {
                //logic 1
        }
}

public class MainClass{
        public static void main(){
                Runnable Obj = new C1();
                Thread t1 = new Thread( Obj );
                t1.start();
        }
} 
```
---

#### Normal Runnable
```
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //logic 1
            }
        };

```
---
#### Using Anonymous Class
```
        Runnable runnable = new Runnable() {
            public void run() {
                //logic 1
            }
        };
        
        Thread t1 = new Thread( runnable );
        t1.start;

```
---

#### Runnable replased as lambda expression
```

        Runnable runnable1 = () -> {
            //logic 1
        };

        Thread t1 = new Thread(runnable1);
        t1.start();
```
---
#### Multiple threads using lambda expression
```
        Thread t1 = new Thread(() -> {
            //logic 1
        });
        Thread t2 = new Thread(() -> {
            //logic 2
        });
        Thread t3 = new Thread(() -> {
            //logic 3
        });
        t1.start();
        t2.start();
        t3.start();
```
