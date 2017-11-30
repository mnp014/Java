class employee
{
    public static void main(String[] args)
    {
        employee_details e1= new employee_details();
        e1.id=1;
        e1.name="abc";
        e1.salary=5000.00;
        e1.designation="developer";

        employee_details e2= new employee_details();
        e2.id=1;
        e2.name="abc";
        e2.salary=5000.00;
        e2.designation="developer";
display d1=new display();
d1.display_();
    }
}


class employee_details
{
    int id;
    String name,designation;
    double salary;

    void work()
    {
        System.out.println("working");
    }    
}

class display
{
void display_()
{
    System.out.println(e1.id);
}

}