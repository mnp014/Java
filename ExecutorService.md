```
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            service.execute(() -> {
                //logic 1
            });
        }


```
___
#### Expansion:
___
```
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            service.execute( new Runnable() {
              @Override
                public void run() {
                  //logic 1
                }
            });
        }


```
---
```
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //logic 1
            }
        };

        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            service.execute( runnable );
        }


```
