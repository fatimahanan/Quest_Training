package com.quest.practice_vars;

public class Operators
{
    public static void main(String[] args)
    {
        int a=10;
        int b=5;
        //arithmetic operators
        System.out.println("Sum = "+(a+b));
        System.out.println("Difference = "+(a-b));
        System.out.println("Product = "+(a*b));
        System.out.println("Quotient = "+(a/b));
        System.out.println("Remainder = "+(a%b));
        //relational operators
        System.out.println(a==b);
        System.out.println(a!=b);
        System.out.println(a<b);
        System.out.println(a>b);
        System.out.println(a<=b);
        System.out.println(a>=b);
        //logical operators
        boolean x=true;
        boolean y=false;
        System.out.println(x&&y);
        System.out.println(x||y);
        System.out.println(x!=y);
        //Assignment operators
        int n=10;
        n+=5; //n=n+5
        //Unary operators
        System.out.println("n = "+n);
        System.out.println(n++);
        System.out.println(++n);
        System.out.println(n);
        System.out.println(n--);
        System.out.println(--n);
        System.out.println(n);
        //Ternary op
        int i=4;
        int k=6;
        int result=k<10 ? --k : 0;
        System.out.println("Result is "+result);



    }
}
