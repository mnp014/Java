interface Demo1
{
    final static int x=12;
    abstract void test();
}
// called as implimentation class
class Implimentation_Class implements Demo1
{
    public void test()
    {
    System.out.println("test() is implemented in this class");
    }
}
class Interface_
{
    public static void main(String[] args)
    {
        System.out.println("main method");
        Implimentation_Class s1=new Implimentation_Class();
        s1.test();
        System.out.println(Demo1.x);
    }
}