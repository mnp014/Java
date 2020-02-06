#### Syntax:
```
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            service.execute(() -> {
                //logic 1
            });
        }


```
___
#### Multi thread which returns void
```
        ExecutorService service = Executors.newFixedThreadPool(10);
        service.execute(() -> {
            //logic 1
        });
        service.execute(() -> {
            //logic 2
        });
        service.execute(() -> {
            //logic 3
        });

```

#### Multi thread which returns value
```
        ExecutorService service = Executors.newFixedThreadPool(10);
        service.submit(() -> {
            //logic 1
        });
        service.submit(() -> {
            //logic 2
        });
        service.submit(() -> {
            //logic 3
        });

```
#### Multi thread which returns blocking value 
```
for (Integer id : employeeID) {
            CompletableFuture.supplyAsync(
                    () -> fetchEmployee(id))
                    .thenApplyAsync(employeeName -> fetchName(employeeName))
                    .thenApplyAsync(salary -> calculateSalary(salary));
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
