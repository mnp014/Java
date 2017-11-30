class sample5
{
    int x=24;
    double y=12.12;
    void test()
    {
        System.out.println("testin");
    }

}
class sample6
{
    void disp(sample5 args1)
    {

        System.out.println(args1.x+" "+args1.y);
        args1.test();
        args1.x=13;
        args1.y=16.98;

    }

}
class sample4
{
    public static void main(String[] args)
    {
        sample6 S1 = new sample6();
        sample5 S2 = new sample5();
        S1.disp(S2);
        System.out.println(S2.x);
        System.out.println(S2.y);

    }
}