package com.quest.logical;


public class reverseString
{
    public static void main(String[] args) {
        String str="hello";
        String rev="";
        for(int i=str.length()-1;i>=0;i--)
        {
            rev=rev+str.charAt(i);
        }
        System.out.println(str+" : "+rev);
    }
}
