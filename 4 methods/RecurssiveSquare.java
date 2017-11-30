class RecurssiveSquare
{
    public static void sq(int x) 
	{
        if(x<10)
            {
            System.out.println(+x);
		    sq(++x);
            }
     }
	public static void main(String[] args) 
	{
		System.out.println("prog tarted");
        sq(1);
		System.out.println("prog ended");
	}
}
