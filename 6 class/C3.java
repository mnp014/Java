class C1
{
	static void f1() 
	{
		C2.c2f1();
		System.out.println("class2 f1 from c1");
	}
	static void f2() 
	{
		System.out.println("c2 f2");
	}
}

class C2
{
	static void c2f1() 
	{
		System.out.println("c2 f1");
	}
	static void c2f2() 
	{
		System.out.println("c2 f2");
	}
}
class  C3
{
	public static void main(String[] args) 
	{
		C1.f1();					
		System.out.println("main"+"accessing class c1");
	}
}
