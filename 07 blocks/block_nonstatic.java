class Sample
{
    int j=90;
    static
    {
        System.out.println("1st block");
    }
}
class block_nonstatic
{
    static
    {
        System.out.println("1st block mainclass2");
    }
    public static void main(String[] args)
    {
        System.out.println("main method");
        Sample ref=new Sample();
        System.out.println("main method"+ref.j);       
    }
    static
    {
        System.out.println("2st block");
    }
}
