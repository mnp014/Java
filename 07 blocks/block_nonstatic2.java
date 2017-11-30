class Sample2
{
    int j=90;
    static
    {
        System.out.println("1st block");
    }
}
class block_nonstatic2
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
        System.out.println("main method"+ref.j);        // calling class Sample2 again_&_again will not initialize {static block} again_&_again
        System.out.println("main method"+ref.j);       
    }
    static
    {
        System.out.println("2st block");
    }
}
