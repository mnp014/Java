class pen
{
String inkcolor;
double price;
pen(String args1,double args2)
{
inkcolor=args1;
price=args2;
}
void write()
{
System.out.println("writin");
}
}
class salesman
{
    pen buy(double amt)
    {
    pen p1=new pen("blue",25.00);
      if (amt>p1.price)
        {
        return p1;
        }
        else
        {
        return null;
        }
    } 
}   
class MainClass2
{
public static void main(String[] args)
    {
    salesman s1=new salesman();
    pen mypen=s1.buy(30.00);
    mypen.write();
    }
}