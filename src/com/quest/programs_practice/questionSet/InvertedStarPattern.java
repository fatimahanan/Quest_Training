package com.quest.programs_practice.questionSet;

public class InvertedStarPattern
{
    public static void main(String[] args) {
//        ***
//         **
//          *
        for(int i=1;i<=3;i++)
        {
            for(int j=1;j<=i;j++)
                System.out.print(" ");
            for(int k=3;k>=i;k--)
                System.out.print("*");
            System.out.println();
        }
    }
}
