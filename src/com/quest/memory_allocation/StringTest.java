package com.quest.memory_allocation;

public class StringTest
{
    public static void main(String[] args)
    {
        StringBuilder s1=new StringBuilder("house");
        StringBuffer s2=new StringBuffer("house");
//        check(s1,s2);
        System.out.println("s1 : "+s1);
        System.out.println("s2 : "+s2);
        System.out.println("\nAppending world with s1");
        s1.append("help");
        System.out.println(s1);
        System.out.println("\nConverted s1 to string\n"+s1.toString());
        System.out.println("\nReversed s1\n"+s1.reverse());
        System.out.println("\nReversed s2\n"+s2.reverse());
        System.out.println("\nReplacing h with m in s2\n"+s2.replace(0,1,"m"));
        System.out.println("\nDeleting 0th index from s2\n"+s2.delete(0,1)); //s=tart to end-1
        System.out.println("\nInserting sp at the beginning of s2\n"+s2.insert(0,"sp"));
        System.out.println("\nReturning character at 2nd index \n"+s2.charAt(2));
    }

    public static void check(StringBuilder s1, StringBuilder s2)
    {
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


}
