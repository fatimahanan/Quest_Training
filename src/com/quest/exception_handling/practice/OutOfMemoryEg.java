package com.quest.exception_handling.practice;

public class OutOfMemoryEg //error
{
    public static void main(String[] args)
    {
        try
        {
            causeOutOfMemory();
        }
        catch(OutOfMemoryError e)
        {
            System.out.println("error has occurred, out of memory!");
            e.printStackTrace();
        }

    }

    public static void causeOutOfMemory()
    {
        int[][] arr=new int[Integer.MAX_VALUE][10];
        int i=0;
        while (true)
        {
            arr[i] = new int[10000000];
            i++;
        }
//        try
//        {
//            while (true)
//            {
//                arr[i] = new int[10000000];
//                i++;
//            }
//        }
//        catch (OutOfMemoryError e)
//        {
//            System.out.println("Exception has occurred, out of memory!");
//            e.printStackTrace();
//        }
    }
}
