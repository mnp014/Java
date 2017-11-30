class switch_ 
{
	public static void main(String[] args) 
	{
		char grade='F';
		switch(grade)    // Breaks with break keyword or '}' symbol unlike c++
		{
			case 'A':
				System.out.println("FCD");
				break;
			case 'B':
				System.out.println("FC");
				break;
			case 'C':
				System.out.println("SC");
				break;
			case 'D':
				System.out.println("just pass");
				break;
			default:
				System.out.println("fail");
		}	
	}
}
