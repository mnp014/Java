class Block_Static
{
    static
    {
        System.out.println("1st block");
    }
    public static void main(String[] args)
    {
        System.out.println("main method");
    }
    static
    {
        System.out.println("2st block");
    }
}
