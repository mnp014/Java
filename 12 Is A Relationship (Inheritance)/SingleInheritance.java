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
class SingleInheritance
{
    public static void main(String[] args)
    {
        demo2 D1=new demo2();
        System.out.println(D1.x);
        System.out.println(D1.y);
        D1.test();
        D1.disp();
    }
}