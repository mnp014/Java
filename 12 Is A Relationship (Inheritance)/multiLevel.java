class demo1
{
int x=100;
static int z=200;//NOTE: final class,static members aswell as constructors cannot be inheriited by subclass
void test()
{
    System.out.println(" test...");
}
}
class demo2 extends demo1
{
double y=2.80;
void disp()
{
    System.out.println("disp....");
}
}
class demo3 extends demo2
{
double a=2.80;
void disp_()
{
    System.out.println("disp....");
}
}
class multiLevel
{
    public static void main(String[] args)
    {
        demo3 D1=new demo3();
        System.out.println(D1.x);
        System.out.println(D1.y);
        System.out.println(D1.a);
        D1.test();
        D1.disp();
        D1.disp_();
    }
}

/*
                                        [demo1]
                                           | 
                                        [demo2]
                                           |
                                        [demo3] 
*/

