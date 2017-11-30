//accessing class members
//Classname.membername
class  ClassExtra
{
	static int  x=12  ;
    static void f1() 
	{
		System.out.println(x);
        Extra2.f1();
        Extra2.x=18;
        System.out.println(Extra2.x);

	}
	
}
class  Extra2
{
	static int  x=1 ;
    static void f1() 
	{
		System.out.println(x);
	}
	
}
class  AcessingStaticMember
{
	public static void main(String[] args) 
	{
					
		ClassExtra.f1();						// accessing class c1
		ClassExtra.x=2;
        System.out.println(ClassExtra.x);
	}
}