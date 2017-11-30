class demo4
{
int x=100;
static int z=200;//NOTE: final class,static members aswell as constructors cannot be inheriited by subclass
void test()
{
    System.out.println(" test...");
}
}
class demo5 extends demo4
{
double y=2.80;
void disp()
{
    System.out.println("disp....");
}
}
class demo6 extends demo4
{
double y=2.80;
void disp()
{
    System.out.println("disp....");
}
}
class heirarchical_
{
    public static void main(String[] args)
    {
        demo5 D1=new demo5();
        System.out.println(D1.x);
        System.out.println(D1.y);
        D1.test();
        D1.disp();
    }
}

/*


                         [demo 4]
                            /\
                           /  \
                          /    \
                         /      \
                  [demo5]       [demo6]

*/