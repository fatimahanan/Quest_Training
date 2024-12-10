package com.quest.thread.useCaseQuestion.MatrixMultiplication;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter m : ");
        int m=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter n : ");
        int n=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter p : ");
        int p=sc.nextInt();
        sc.nextLine();
        int[][] a=new int[m][n];
        int[][] b=new int[n][p];
        int[][] result=new int[m][p];
        System.out.println("Enter values for matrix 'a' of "+m+"x"+n+" dimensions : ");
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                a[i][j]=sc.nextInt();
                sc.nextLine();
            }
        }
        System.out.println("Displaying matrix : ");
        displayMatrix(a,m,n);
        System.out.println("Enter values for matrix 'b' of "+n+"x"+p+" dimensions : ");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<p;j++)
            {
                b[i][j]=sc.nextInt();
                sc.nextLine();
            }
        }
        displayMatrix(b,n,p);
        try
        {
            for(int i=0;i<m;i++) //for every row of result matrix
            {
                Thread t=new MatrixMultiplication(i,n,a,b,result);
                t.start();
                t.join();
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("Product : ");
        displayMatrix(result,m,p);
    }
    public static void displayMatrix(int[][] matrix,int row,int column)
    {
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
