interface Demo1
{
     void test();
     void disp();
}

// abstract  '.' Not all the abstract methods are declared [only test()]
abstract class Sample1 implements Demo1
{
    public void test()
    {
    System.out.println("test() is implemented in this class");
    }
    
}
// concrete   '.'  all the abstract methods are declared [both test() & disp()]
class Sample2 extends Sample1
{
    
    public void disp()
    {
    System.out.println("disp() is implemented in this class");
    }
}
class Abstract_VS_Concrete_Class
{
    public static void main(String[] args)
    {
        System.out.println("main method");
        Sample2 s1=new Sample2();
        s1.test();
        s1.disp();
    }
}