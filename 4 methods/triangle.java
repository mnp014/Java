class triangle
{
	
	public static void area() 
	{
	for(int k=6;k>=0;k--)              // ROWS
			{
				for(int i=k;i>=0;i--)					// COLUMNS
				{

					System.out.print(+i);
				}
					System.out.println("");
				
			}	
	}

	public static void main(String[] args) 
	{
	System.out.println("main");
	area();
	
	}

	
}
