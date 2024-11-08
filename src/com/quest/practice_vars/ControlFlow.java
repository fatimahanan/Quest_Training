package com.quest.practice_vars;

public class ControlFlow
{
    public static void main(String[] args)
    {
        int number=6;
        if(number<0)
            System.out.println(number+" is negative");
        else if(number>0)
            System.out.println(number+" is positive");
        else
            System.out.println(number+" is zero");

        String day="Monday";
        int dayNumber=0;
        switch(day)
        {
            case "Monday":
                dayNumber = 1;
                break;
            case "Tuesday":
                dayNumber = 2;
                break;
            case "Wednesday":
                dayNumber = 3;
                break;
            case "Thursday":
                dayNumber = 4;
                break;
            case "Friday":
                dayNumber = 5;
                break;
            case "Saturday":
                dayNumber = 6;
                break;
            case "Sunday":
                dayNumber = 7;
                break;
            default:
                System.out.println("Invalid day");
                break;
        }
        System.out.print(day+" : day "+dayNumber+" of the week\n");
        testForLoop();
    }
    static void testForLoop()
    {
        //prints even numbers
        System.out.println("Even numbers upto 10");
        for(int i=0;i<10;i++)
        {
            if(i%2==0)
                System.out.println(i);
            else
                continue;
        }
    }

    static void testWhileLoop()
    {
        int i=1;
        while(i<=5)
        {
            System.out.println(i);
            i++;
        }
    }
}
