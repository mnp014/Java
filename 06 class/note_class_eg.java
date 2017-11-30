class note_class
{
    int pages,pgno;
    String brand;
    double price;

void turnPages(int pgno)
{
    pgno++;
    System.out.print("pages no: ");
    return pgno;
}    
void open()
    {
    int pgno=1;
    System.out.print("opened");
    System.out.print("pages: "+pages);
    System.out.print("brand: "+brand);
    System.out.print("price: "+price);
    }
void close()
    {
        System.out.print("closed");
    }
}


class note_class_eg
{
public static void main(String[] args)
{
    int pgNo;
    note_class b1= new note_class();
    b1.pages=100;
    b1.brand="xyz";
    b1.price=11.23;

    note_class b2= new note_class();
    b2.pages=90;
    b2.brand="xyz";
    b2.price=11.23;
    b1.open();
    b2.open();
    pgNo=b1.turnPages(int b1.pgno);
    pgNo=b2.turnPages(int b2.pgno);
    b1.close();
    b2.close();
}
}
