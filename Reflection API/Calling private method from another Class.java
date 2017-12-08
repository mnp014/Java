Test.java
------------------------------------------------------------------------------------------------------------------
public class Test {  
  private void sample(){System.out.println("hello java"); }  
}  
__________________________________________________________________________________________________________________
PrivateMethodClass.java
------------------------------------------------------------------------------------------------------------------
import java.lang.reflect.Method;  

public class PrivateMethodClass{  
    public static void main(String[] args)throws Exception{  
  
        Class cls = Class.forName("Test");  
        Object obj= cls.newInstance();  
        Method method =cls.getDeclaredMethod("sample", null);  
        method.setAccessible(true);  
        method.invoke(obj, null);  
   }  
}  
__________________________________________________________________________________________________________________
