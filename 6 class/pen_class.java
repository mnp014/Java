class pen_class
{
    String color;
    String brand;
    double price;
void display_()
    {
    System.out.print("color: "+color);
    System.out.print("brand: "+brand);
    System.out.print("price: "+price);
    }
void write()
    {
        System.out.print("writing");
    }
}


class pen_class_eg
{
public static void main(String[] args)
{
    pen_class p1= new pen_class();
    p1.color="blue";
    p1.brand="xyz";
    p1.price=11.23;

    pen_class p2= new pen_class();
    p2.color="blue";
    p2.brand="xyz";
    p2.price=11.23;
    p1.display_();
    p2.display_();
    p1.write();
    p2.write();
}
}
