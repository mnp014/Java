class MainClass1
{
    static int j=90;
    static
    {
        System.out.println("1st block");
    }
}
class MainClass2
{
    static
    {
        System.out.println("1st block mainclass2");
    }
    public static void main(String[] args)
    {
        System.out.println("main method");
        System.out.println("main method"+MainClass1.j);
    }
    static
    {
        System.out.println("2st block");
    }
}
