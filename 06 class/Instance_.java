class Instance_ 
{
	void nonStaticF() 
	{
		System.out.println("c1 f1");
	}
	static void staticF() 
	{
		System.out.println("c2 f2");
	}
}

class  Instance_main
{
	public static void main(String[] args) 
	{
		Instance_ C1 = new Instance_();			// new operator always returns ADDRESS of the instance
		C1.nonStaticF();					
		Instance_.staticF();						// accessing static members
		System.out.println("main"+"accessing class c1");
	}
}
