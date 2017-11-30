class Student_
{
    final int id;
    String name;
    Student_(int arg1,String arg2)
    {
        id=arg1;
        name=arg2;
    }
}
class Student
{
    public static void main(String[] args)
    {
    Student_ s1=new Student_(12,"abc");
    System.out.println(s1.id+s1.name);
    Student_ s2=new Student_(12,"xyz");
    System.out.println(s2.id+s2.name);
}
}