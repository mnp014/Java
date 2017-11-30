abstract class Demo1
{
    int x=100;
    static int y=20;
    void test()
    {
        System.out.println("Non-static method");
    }
    static void disp()
    {
        System.out.println("static method");
    }
}
class Sample extends Demo1
{

}
class Abstract_Class
{
    public static void main(String[] args)
    {
        Sample S1= new Sample();
    //Non-static members of ABSTRACT class
        S1.test();
        System.out.println(S1.x);
    //static members of ABSTRACT class
        Demo1.disp();
        System.out.println(Demo1.y);
    }
}