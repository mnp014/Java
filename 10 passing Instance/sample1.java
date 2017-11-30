class sample2
{
    int x=24;
    double y=12.12;
    void test()
    {
        System.out.println("testin");
    }

}
class sample3
{
    void disp(sample2 args1)
    {

        System.out.println(args1.x+" "+args1.y);
        args1.test();
    }

}
class sample1
{
    public static void main(String[] args)
    {
        sample3 S1 = new sample3();
        S1.disp(new sample2());

    }
}