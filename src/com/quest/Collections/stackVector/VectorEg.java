package com.quest.Collections.stackVector;

import java.util.Vector;

public class VectorEg
{
    public static void main(String[] args)
    {
        Vector<Integer> vector=new Vector<Integer>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        System.out.println("displaying...");
        for(int v:vector)
        {
            System.out.println(v);
        }
        System.out.println("\nsize : "+vector.size());
        System.out.println("\nget 0th element : "+vector.get(0));
        System.out.println("get 1st element : "+vector.get(1));
        System.out.println("\ndoes it contain 2 ? : "+vector.contains(2));
        System.out.println("does it contain 5 ? : "+vector.contains(5));
        System.out.println("\nis the stack empty : "+vector.isEmpty());
        System.out.println("\nremoved element : "+vector.remove(3));
        System.out.println("displaying...");
        for(int v:vector)
        {
            System.out.println(v);
        }
        System.out.println("\nfirst element : "+vector.firstElement());
        System.out.println("last element : "+vector.lastElement());

    }
}
