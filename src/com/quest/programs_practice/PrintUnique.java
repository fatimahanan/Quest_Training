package com.quest.programs_practice;

public class PrintUnique
{
    public static void main(String[] args)
    {
        int[] arr = new int[10];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 3;
        arr[3] = 9;
        arr[4] = 5;
        for(int i=0; i<arr.length; i++)
        {
            int count = 0;
            for (int j = 0; j < arr.length; j++)
            {
                if (arr[j] == arr[i])
                    count++;
            }
            if(count==1)
            {
                System.out.println(arr[i]);
            }

        }
    }
}
