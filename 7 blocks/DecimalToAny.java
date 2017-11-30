import java.util.Scanner;
class DecimalToAny
{
    public static void main(String[] args)
    {
        
		Scanner sc= new Scanner(System.in);
		System.out.println("enter no");
        int no=sc.nextInt();
        System.out.println("enter base");
        int base=sc.nextINt();
        System.out.println(convert_(no,base));
    }
    
    
    
    static String convert_(int dec,int b)
    {
        
        String st="";
        while (dec>0)
        {
            int r=dec%b;
            if(r>9)
            {
                st=(char)(r+55)+st;
            }
            else
            {
                st=r+st;
            }
            dec=dec/b;
        }
      return st;  
    }
}