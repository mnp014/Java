import java.util.Scanner;
class  scanner
{
	public static void main(String[] args) 
	{
		System.out.println("enter string : ");
		Scanner scn1 = new Scanner(System.in);
		String a=scn1.next();												// next() for STRING
		System.out.print(a);


		System.out.println("enter string : ");
		int b = scn1.nextInt();												// next() for INTEGER
		System.out.print(b);


		System.out.println("enter string : ");
		long c = scn1.nextLong();												// next() for INTEGER
		System.out.print(c);

	}
}
