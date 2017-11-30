class nested_if 
{
	public static void main(String[] args) 
	{
		double bal=50000,amt=30000;
		int pin =5959;
		if (pin==5959)
		{
		
			if (amt>bal)
			{
				System.out.println(+bal+ " amt available ");
			}
			
			else{
				System.out.println(" insufficient balance  remaining balance"+bal);
			}
		}
		else 
			System.out.println("wrong pin");
	}
}
