interface Demo1
{
     void test();
}
interface Demo2 extends Demo1
{
     void disp();
}
// called as implimentation class
class Sample implements Demo2
{
    public void test()
    {
    System.out.println("test() is implemented in this class");
    }
    public void disp()
    {
    System.out.println("disp() is implemented in this class");
    }
}
class Interface_extends_interface
{
    public static void main(String[] args)
    {
        System.out.println("main method");
        Sample s1=new Sample();
        s1.test();
        s1.disp();
    }
}