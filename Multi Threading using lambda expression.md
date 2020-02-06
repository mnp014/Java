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
