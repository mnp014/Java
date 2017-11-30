class sample1
{
    sample1(int arg1)
    {
    System.out.println("sample1");
    System.out.println("arg1 is"+arg1);
    }
}
class sample2 extends sample1
{
sample2()
{
    super(25);                                // super keyword used to initialize constuctor of base class 
    System.out.println("no arg sample2");
}
}
class MainClass4
{
public static void main(String[] args)
    {
    System.out.println("prog stated");
    sample2 s1= new sample2();
    }
}