class program2
{
    public static void main(String[] args)
    {
        System.out.println(12345);        // print int
        System.out.println(23.5);         // print float   
        System.out.print('j');            // print character
        System.out.println(true);         // print boolean
        System.out.print(false);          // print boolean
        System.out.print("Some String");  // print String
        
        int i;          // initialize integer
        float f;        // initialize float
        byte b;         // initialize byte
        short sh;        // initialize short
        long l;         // initialize long
        double d;       // initialize double
        char ch;         // initialize char
        boolean bool;      // initialize boolean
        
        l='a';           //  long value 97 is initialized using character, '.' The Unicode value of 'a' is 97.
        i=5;             //  int value is assigned.  
        f=9990;          //  float value is assigned.
        i=1;             //  int value is Re-Assigned.
        sh=8;            //  Short value is assigned
        b = 10;          //  byte value is assigned
        d = 2.71828;     //  double value is assigned
        ch = 'Z';        //  char value is assigned
        bool = true;     //  boolean value is assigned

        System.out.println(l);     // Prints 97
        System.out.println(i);     // Prints 1, Notice s has been overwritten as it was reassigned
        System.out.println(f);     // Prints 9990.0
        System.out.println(i);     // Prints 1
        System.out.println(sh);     // Prints 8

        // Print formatted
        System.out.printf("int: %d%n", i);
        System.out.printf("float: %.2f%n", f);
        System.out.printf("byte: %d%n", b);
        System.out.printf("short: %d%n", sh);
        System.out.printf("long: %d%n", l);
        System.out.printf("double: %.5f%n", d);
        System.out.printf("char: %c%n", ch);
        System.out.printf("boolean: %b%n", bool);
    }
}
