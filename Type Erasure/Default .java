// Here, "X" is bounded by Object i.e. java.lang.Object , .'.  Here, "X" will be replaced by default ie "Object"
--------------------------------------------------------------------------------------------------------------------
class Sample<P> {

    X obj; 
 
    Sample(X o)
    {
        obj = o;
    }
    X getobj()
    {
        return obj;
    }
}

____________________________________________________________________________________________________________________
After compilation, All the "X" in the code is replaced by default ie "Object" as shown below:
--------------------------------------------------------------------------------------------------------------------
class Sample
{
    Object obj;
    Sample(Object o)
    {
        obj=o;
    }
    Object getobj()
    {
        return obj;
    }
}
________________________________________________________________________________________________________________
