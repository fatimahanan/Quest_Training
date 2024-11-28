package com.quest.programs_practice;

public class FindDuplicateStrings
{
    public static void main(String[] args) {
        String[] arr={"java","python","kotlin","java","c++","python","kotlin"};
        for(int i=0;i<arr.length;i++)
        {
            boolean isDupli=false;
            for(int j=0;j<i;j++)
            {
                if(arr[i].equals(arr[j]))
                {
                    isDupli=true;
                    break;
                }
            }
            if(isDupli)
            {
                System.out.println(arr[i]);
            }
        }
    }
}
