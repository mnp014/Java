//no pass by reference in JAVA '.' no pointers in java

class DebitCard
{
    String name;
    double balance;
    long cName;
    DebitCard(long arg1,double arg2,String arg3)
    {
    cName=arg1;
    balance=arg2;
    name=arg3;
    }
}

class BillPayment
{
    void payment(DebitCard arg,double billAmt)
    {
    System.out.println("processing payment");
    if(arg.balance>billAmt)
        {
        arg.balance= arg.balance-billAmt;
        System.out.println("payment success");
        System.out.println(arg.balance);
        }
    else
        {
        System.out.println("payment failed");
        }
    }
}
class MainClass3
{
    public static void main(String[] args)
    {
        DebitCard d1 = new DebitCard(100,1000000,"meghraj");
        BillPayment b1 = new BillPayment();
        b1.payment(d1,10000.00);
    }
}