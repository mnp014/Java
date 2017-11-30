import java.util.Scanner;
class  dynamic_array
{
	public static void main(String[] args) 
	{
		System.out.println("enter array size : ");
		Scanner scn1 = new Scanner(System.in);
		int n=scn1.nextInt();												// next() for STRING
		int number[];
		number=new int[n];

        System.out.println("enter array elements");
        for(int i=0;i<n;i++)
        {
         number[i]=scn1.nextInt();
        }


		

	}
}
