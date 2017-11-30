class demo1
{
    void disp()
    {
        System.out.println("demo1");
    }
}
//Advantage: compile time polymorphism
class demo2 extends demo1
{
    void disp(int a)
    {
        System.out.println(a);
    }
}

class Method_Overloading
{
    public static void main(String[] args)
    {
        demo2 d1=new demo2();
        d1.disp();
        d1.disp(20);

    }
}