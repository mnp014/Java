class Sample3
{
    int i=100;          //initializing here is waste since it just acts as default value
    static double d;
    static
    {
        d=50;
        System.out.println("static block");
    }

    {
        i=70;
        System.out.println("non static block");
    }
}
class Nonstatic_block2
{
    public static void main(String[] args)
    {
        System.out.println("main method");
        System.out.println("d value"+Sample3.d);
        Sample3 ref = new Sample3();
        System.out.println("i value"+ref.i);
    }
}