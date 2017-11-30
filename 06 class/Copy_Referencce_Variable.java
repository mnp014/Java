// static means ONCE
//eg: FACEBOOK is static ,FB accounts non static


class Instance_ 
{
    int x=100;
	void nonStaticF() 
	{
        System.out.println("c1 f1");
	}
	static void staticF() 
	{
		System.out.println("c2 f2");
	}
}

class  Copy_Referencce_Variable
{
	public static void main(String[] args) 
	{
		Instance_ C1 = new Instance_();			// new operator always returns ADDRESS of the instance
		Instance_ C2 = C1;
        C1.nonStaticF();
        int z=C1.x;					        //accessing nonStatic members
		System.out.println(C1+"  "+C2+" "+z);
	}
}
