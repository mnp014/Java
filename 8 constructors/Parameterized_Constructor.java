class demo6
{
        int x;
        double y;
  
    demo6(int args1,double args2)
    {
        System.out.println("running parameterized constructor");
        x=args1;
        y=args2;
    }

    void display()
    {
        System.out.println(+x);
        System.out.println(+y);
    }
}

class Parameterized_Constructor
{
    public static void main(String[] args)
    {
        demo6 D1= new demo6(14,89.09);
        D1.display();
        demo6 D2= new demo6(23,339.09);
        D2.display();
    }
}