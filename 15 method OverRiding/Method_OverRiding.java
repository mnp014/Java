class demo1
{
    void disp()                                     //this method is never accessed since it is over ridden by demo2
    {
        System.out.println("before overriding");
    }
}
//Advantage: compile time polymorphism
class demo2 extends demo1
{
    void disp()
    {
        System.out.println("Method Over Ridden");
    }
}

class Method_OverRiding
{
    public static void main(String[] args)
    {
        demo2 d1=new demo2();
        d1.disp();
        demo1 d2=new demo1();
        d2.disp();
    }
}