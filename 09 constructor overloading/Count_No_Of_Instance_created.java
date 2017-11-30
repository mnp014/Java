class No_Of_Instance
{
static int count=0;                       //declared Static so that it wont reset to 0 everytime an INSTANCE is created
    No_Of_Instance()
    {
    count++;
    }

}

class Count_No_Of_Instance_created
{
    public static void main(String[] args)
    {
        for(int i=0;i<5;i++)
        {
        new No_Of_Instance();
        }
System.out.println(No_Of_Instance.count)   ; 
}
}