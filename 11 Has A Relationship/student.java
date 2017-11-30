class Demo1
{
int x=10;
double y=24.7;
void test()
    {
        System.out.println("demo1");
    }
}

class Sample1
{
char z='a';
static Demo1 d1 = new Demo1();
void disp()    
    {
            System.out.println("sample1");
            //System.in.read();
    }
}
class Main1_
{
    public static void main(String[] args)
    {
    Sample1 s1 =new Sample1();
    System.out.println("sample1");
    s1.disp();
    System.out.println(Sample1.d1.x);
    System.out.println(Sample1.d1.y);
    Sample1.d1.test();

    }

}