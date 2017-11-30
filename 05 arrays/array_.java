class array_ 
{
	public static void main(String[] args) 
	{
		int[] arr={1,2,3,45,7};
		int chara[];
		chara=new int[8];
				for(int i=0;i<5;i++)
				{
				System.out.print(+arr[i]+" ");
				}

		int k=1;
				for(int i=0;i<8;i++)
				{
					chara[i]=k++;
				}	

		for(int i=0;i<5;i++)
				{
				System.out.print(+chara[i]);
				}		

	}
}
