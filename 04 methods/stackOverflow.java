class stackOverflow
{
    public static void f() 
	{
		f();
    }
	public static void main(String[] args) 
	{
		System.out.println("prog tarted");
        f();
		System.out.println("prog ended");
	}
}
