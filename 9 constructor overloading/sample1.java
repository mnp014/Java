class sample2
{
    int x;
    char y;
    sample2(int arg1,char arg2)
    {
        x=arg1;
        y=arg2;
    }
    sample2(int arg1)
    {
        x=arg1;
    }
 void disp()
    {
        System.out.println(x);
        System.out.println(y);
    }
   
}

class sample1
{
   public static void main(String[] args)
    {
         
         sample2 D1= new sample2(12,'a');
         D1.disp();

    }
}
        
        