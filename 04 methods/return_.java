class return_ 
{
	
	static boolean checkno(int x) 
	{
		if(x>10)
			return true;
		else
			return false;
	}
	public static void main(String[] args) 
	{
		System.out.println(checkno(7));
		System.out.println(checkno(12));
	}
}
