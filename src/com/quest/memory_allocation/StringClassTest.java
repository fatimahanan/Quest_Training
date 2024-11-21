package com.quest.memory_allocation;

public class StringClassTest
{
    public static void main(String[] args)
    {
        String s1=new String("boot");
        String s2=new String("boot");
        StringBuilder s3=new StringBuilder("boot");
        StringBuilder s4=new StringBuilder("boot");
        StringBuffer s5=new StringBuffer("boot");
        StringBuffer s6=new StringBuffer("boot");
        check(s1,s2);
        check(s3,s4);
        check(s5,s6);
        System.out.println("**********************************************");
        System.out.println("Operations on StringBuilder");
        System.out.println("\nAppending world with s3");
        s3.append("strap");
        System.out.println(s3);
        System.out.println("\nConverted s3 to string\n"+s3);
        System.out.println("\nReversed s3\n"+s3.reverse());
        System.out.println("\nReversed s3 back\n"+s3.reverse());
        System.out.println("\nReplacing b with l in s3\n"+s3.replace(0,1,"l"));
        System.out.println("\nDeleting 0th index from s3\n"+s3.delete(0,1)); //s=tart to end-1
        System.out.println("\nInserting l at the beginning of s2\n"+s3.insert(0,"l"));
        System.out.println("\nReturning character at 4th index \n"+s3.charAt(3));

        System.out.println("*********************************************");
        System.out.println("Operations on StringBuffer");
        System.out.println("\nAppending world with s5");
        s3.append("strap");
        System.out.println(s3);
        System.out.println("\nConverted s3 to string\n"+s5);
        System.out.println("\nReversed s3\n"+s5.reverse());
        System.out.println("\nReversed s3 back\n"+s5.reverse());
        System.out.println("\nReplacing b with l in s3\n"+s5.replace(0,1,"l"));
        System.out.println("\nDeleting 0th index from s3\n"+s5.delete(0,1)); //s=tart to end-1
        System.out.println("\nInserting l at the beginning of s2\n"+s5.insert(0,"l"));
        System.out.println("\nReturning character at 4th index \n"+s5.charAt(3));
    }
    public static void check(String s1, String s2)
    {
        System.out.println("\nString class");
        System.out.println("Comparing "+s1+" and "+s2);
        System.out.println("==");
        if(s1==s2)
            System.out.println(true);
        else
            System.out.println(false);
        System.out.println("\nequals");
        if(s1.equals(s2))
            System.out.println(true);
        else
            System.out.println(false);
    }

    public static void check(StringBuilder s1, StringBuilder s2)
    {
        System.out.println("\nStringBuilder class");
        System.out.println("Comparing "+s1+" and "+s2);
        System.out.println("==");
        if(s1==s2)
            System.out.println(true);
        else
            System.out.println(false);
    }

    public static void check(StringBuffer s1, StringBuffer s2)
    {
        System.out.println("\nStringBuffer class");
        System.out.println("Comparing "+s1+" and "+s2);
        System.out.println("==");
        if(s1==s2)
            System.out.println(true);
        else
            System.out.println(false);
    }
}

