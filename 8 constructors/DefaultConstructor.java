class demo1
{
    int x;
    int y;
    char a;    // returns garbage value

    void display()
    {
        System.out.println(x);
        System.out.println(y);
        System.out.println(a);
    }
}

class DefaultConstructor
{
    public static void main(String[] args)
    {
        demo1 D1 = new demo1();
        System.out.println(D1.x);
        System.out.println(D1.y);
        System.out.println(D1.a);
    }
}