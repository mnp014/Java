### 1) Signed
#### Signed Right Shift:   
```
public class Main
{
    public static void main(String args[])  {
       int x = -8;
       System.out.println(x>>1);   
    }    
}
```
###### O/P:
```
i/p| o/p
-8 | -4
 8 |  4
-1 |  1
 1 |  0
 0 |  1
```
--- 
#### Signed Left Shift:   
```
public class Main
{
    public static void main(String args[])  {
       int x = -8;
       System.out.println(x<<1);   
       int x = 8;
       System.out.println(x<<1);  
       int y = -1;
       System.out.println(y<<1);
       int z = 1;
       System.out.println(z<<1);
    }    
}
```
###### O/P:
```
i/p| o/p
-8 | -16
 8 |  16
-1 |  2
 1 |  2
 0 |  0
```

___
### 2) Un-Signed

#### Un-Signed Right Shift:  
```
public class Main
{
    public static void main(String args[])  {
       // x is stored using 32 bit 2's complement form. 
       // Binary representation of -1 is all 1s (111..1)       
       int x = -1;  
  
       System.out.println(x>>>29);  // The value of 'x>>>29' is 00...0111
       System.out.println(x>>>30);  // The value of 'x>>>30' is 00...0011 
       System.out.println(x>>>31);  // The value of 'x>>>31' is 00...0001 
    }    
}
```
###### O/P:
```
7
3
1
```
---  
#### Un-Signed Left Shift:  
```
Unlike unsigned Right Shift, there is no `<<<` operator in Java,
because the logical `<<` and arithmetic left-shift `<<<` operations are identical.
```
