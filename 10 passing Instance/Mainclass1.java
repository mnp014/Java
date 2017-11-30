class demo
{
    int x=24;
    double y=12.12;
    void test()
    {
        System.out.println("testin");
    }

}
class Sample7
{
void disp(demo args)
    {
        System.out.println("running");
        System.out.println(+args.x);
        System.out.println(+args.y);
        args.test();  
    }
}
class Mainclass1
{
    public static void main(String[] args)
    {
    System.out.println("started");
    Sample7 s1 = new Sample7();
    s1.disp(new demo());
    System.out.println("ends");
    }
}