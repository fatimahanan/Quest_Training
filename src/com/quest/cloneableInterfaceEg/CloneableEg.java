package com.quest.cloneableInterfaceEg;

public class CloneableEg
{
    public static void main(String[] args)
    {
        try
        {
            Person p1=new Person("Hanan",23);
            if(p1 instanceof Cloneable)
            {
                Person p2= (Person) p1.clone();
                System.out.println("original : "+p1);
                System.out.println("clone: "+p2);
                System.out.println(p1==p2);
            }
            else
            {
                System.out.println("p1 not clonable");
            }
        }
        catch(CloneNotSupportedException e)
        {
            e.printStackTrace();
        }
    }
}
