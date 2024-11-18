package com.quest.practice_vars;

import java.util.Scanner;

public class RepeatCount
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string: ");
        String str=sc.nextLine();
        for(int i=0;i<str.length();i++)
            System.out.println(str.charAt(i));

        System.out.println();
        for(int j=0;j<str.length();j++)
        {
            int count=0;
            char current=str.charAt(j);
            for(int k=0;k<str.length();k++)
            {
                if(str.charAt(k)==current)
                    count++;
            }
            if(str.indexOf(current)==j)
                System.out.println(current+"-"+count);
        }
    }
}
