/*an engg col has various dept,each dept has id,name,and HOD for the dept write java program to demonstrate the multiple dept of the college*/

class EnggDept
{
public static void main(String[ args)
    {
    dept d1= new dept();
    d1.id=1;
    d1.name="CSE";
    d1.hod="abc";
    d2.id=2;
    d2.name="IS";
    d2.hod="xyz";
    d1.print_();
    d2.print_();
    }
}

class dept
{
int id;
String name,hod;
void print_()
    {
        System.out.println("dept id : "+id);
        System.out println("dept name : "+name);
        System.out.println("HOD : "+hod);
    }
}