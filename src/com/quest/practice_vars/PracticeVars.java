package com.quest.practice_vars;

public class PracticeVars
{
    final static int VOTE_AGE=18;
    public static void main(String[] args)
    {
        int age=24;
        double salary=60000.00;
        char gender='F';
        String firstName="Pamela";
        String lastName="Andrew";

        System.out.println("Age = "+age);
        System.out.println("Salary = "+salary);
        System.out.println("Gender = "+gender);
        System.out.println("First Name = "+firstName);
        System.out.println("Last Name = "+lastName);
        age=25;
        System.out.println("Age = "+age);
        System.out.println("Voting Age = "+VOTE_AGE);
//        VOTE_AGE=16;  cannot be changed as VOTE_AGE is final
        practiceConversion();
        stringConcatenation();
        stringMethods();
    }

    private static void practiceConversion()
    {
        int a=20;
        double b=25.0;
        double sum=a+b;   //int to double (implicit)
        int round=(int)b; //double to int (explicit)
        System.out.println("Sum = "+sum);
        System.out.println("Round = "+round);
    }

    private static void stringConcatenation()
    {
        String s1="Pamela";
        String s2="Andrew";
        String s3=s1+" "+s2;
        int age=24;
        System.out.println("Name = "+s3+"\nAge = "+age);
    }

    private static void stringMethods()
    {
        String s1="Pamela";   //string literal
        String s2="Andrew";
        String s3=new String("Hello world"); //object in the heap
        String s4=new String ("hello world");
        System.out.println(s3.length());
        System.out.println(s3.equals(s2)); //checks content of s3 and s2
        System.out.println(s3.equals(s4));
        System.out.println(s3.equalsIgnoreCase(s4));
        System.out.println(s3==s4);

    }
}
