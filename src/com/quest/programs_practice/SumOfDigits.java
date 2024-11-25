package com.quest.programs_practice;

public class SumOfDigits
{
    public static void main(String[] args)
    {
        int num=1234;
        num=Math.abs(num);
        int sum=0;
        while(num!=0)
        {
            int dig=num%10;
            sum=sum+dig;
            num=num/10;
        }
        System.out.println("Sum of digits = "+sum);
    }
}
