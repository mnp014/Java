/*COUNT OCCURANCE OF EACH CHARACTER*/



import java.util.Scanner;
class CharCount
{
    public static void main()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter a string");
        sc = nextLine;
    String st=sc;
    int c[]=new int[128];
    char ch[]=st.toCharArray[];
        for(int i=0;i<ch.length;i++)
            {
                c[ch[i]]++;
            }
        for(int i=0;i<c.length;i++)
            {
                if (c[i]>0)
                {
                    System.out.println((char)i+"occures" c[i]+"times");
                }
            }
}