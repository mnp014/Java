abstract class Demo3
{
     abstract void test();
     abstract void disp();
}
abstract class Sample extends Demo3
{
    void test()
    {
        System.out.println("first class");
    }
}
class Sample2 extends Sample
{
    void disp()
    {
        System.out.println("second class");
    }
}
class Abstract_Class_n_Multiple_Iinheritance
{
    public static void main(String[] args)
    {
        Sample2 S1= new Sample2();
        S1.disp();
        S1.test();        

    }
}