class demo5
{

//executed first
    int x;
    int y;
    char a;

{
//NonStatic block executed second.............x,y values updated
    x=50;
    y=40;

}

// Constructor executed third.............x,y values updated

        demo5()
        {
            System.out.println("running user defined constructor");
            x=125;
            y=33;
            a='v';
        }

    void display()
    {
        System.out.println(x);
        System.out.println(y);
        System.out.println(a);
    }
}

class execution_Sequence
{
    public static void main(String[] args)
    {
        demo5 D1 = new demo5();
        System.out.println(D1.x);
        System.out.println(D1.y);
        System.out.println(D1.a);
    }
}

