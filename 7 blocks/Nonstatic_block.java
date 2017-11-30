class sample3
{  
    int k=2;
// initialization NonStatic variables
    {         
        System.out.println("1st Non Static block");                 //non static block are executed when class object is created
    }
}


class Nonstatic_block
{    
    {         
        System.out.println("Non Static block");                 //non static block are executed when class object is created
    }

    public static void main(String[] args)
    {   
        System.out.println("main method");
        sample3 s3=new sample3();
        System.out.println(+s3.k);
    }    
}