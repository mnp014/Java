class accBalance
{
	static double minBalance=5000,amt;
	static boolean checkbal(double x) 
	{
		if(x>minBalance)
			return true;
		else
			return false;
	}
    static boolean withdraw(double x) 
	{
		if(checkbal(x))
            {
		    amt=amt-x;	
            }
        else
            {
			System.out.println("INSUFF BAL");
            }
        return true;
            
	}
	public static void main(String[] args) 
	{
		System.out.println(withdraw(7000.0));
		System.out.println(withdraw(2000.0));
	}
}
