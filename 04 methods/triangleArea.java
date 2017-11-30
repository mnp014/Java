class method 
{
	
	public static void area() 
	{
	
		double a,p,b,c,h,area;
		a=10;
		b=10;
		c=10;
		h=3;
		area=0.5*a*h;
		p=a+b+c;
		System.out.println("area is : " + area);
		System.out.println("perimeter is : " + p);
	}

	public static void main(String[] args) 
	{
	System.out.println("main");
	area();
	}

}
