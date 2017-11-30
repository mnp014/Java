//2 abstract methods

abstract class Demo1
{
    int x=100;
    static int y=20;
    abstract void test();
    static void disp()
    {
        System.out.println("static method");
    }
}
class Sample extends Demo1
{
    void test()
    {
        System.out.println("test is converted to concrete method here");
    }
}
class Sample2 extends Demo1
{
    void test()
    {
        System.out.println("test is converted to another concrete method here");
    }
}
class main
{
    public static void main(String[] args)
    {
        Sample S1= new Sample();
        Sample2 S2= new Sample2();
    //Non-static members of ABSTRACT class
        S1.test();
        S2.test();
        System.out.println(S1.x);
    //static members of ABSTRACT class
        Demo1.disp();
        System.out.println(Demo1.y);
    }
}