class Demo1
{
    int x=20;
    void test()
    {   
        
        System.out.println("test");
    }
}
class Demo2 extends Demo1
{
    void disp()
    {
        System.out.println("disp");
    }
}
class Demo3 extends Demo2
{
    void foo()
    {
        System.out.println("foo");
    }
}
class Sample1
{
    void function1(Demo1 arg)
    {
        System.out.println("function1");
        System.out.println("x value:"+arg.x);
        arg.test();
    }
}



class upcasting_
{
    public static void main(String[] args)
    {
        System.out.println("main");
        Sample1 s1=new Sample1();
        s1.function1(new Demo1());
        s1.function1(new Demo2());
        s1.function1(new Demo3());
        System.out.println("main");
    }
}