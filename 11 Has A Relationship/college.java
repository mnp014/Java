class student
{
String name="abc";
String usn="4kalkmalm";
void disp()
    {
        System.out.println("student details");
    }
}

class dept
{
String name="cs";
static student d1 = new student();
void disp()    
    {
            System.out.println("dept details");
    }
}
class college
{
    public static void main(String[] args)
    {
    dept d1 =new dept();
    System.out.println("college");
    d1.disp();
    System.out.println(dept.d1.name);
    System.out.println(dept.d1.usn);
    //dept.d1.disp();

    }

}