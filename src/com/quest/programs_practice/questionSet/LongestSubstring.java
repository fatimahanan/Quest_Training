package com.quest.programs_practice.questionSet;

import java.util.Scanner;

public class LongestSubstring
{
    public static void main(String[] args)
    {
        String[] str={"flower","flw","flop"};
        if(str==null || str.length==0)
        {
            System.out.println("empty string array.");
            return;
        }
        else
        {
            for(int i=0;i<str[0].length();i++)
            {
                char character=str[0].charAt(i);
                for(int j=1;j<str.length;j++)
                {
                    if(i>=str[j].length() || str[j].charAt(i)!=character)
                    {
                        System.out.println(str[0].substring(0, i));
                        return;
                    }
                }
            }
        }


    }
}
