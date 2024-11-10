package com.quest.practice_vars;

import java.util.Scanner;

public class EmployeeSalaryManagement
{
    public static void main(String[] args)
    {
        String name;
        int noOfEmployees=0;
        int baseSal=0;
        int[] monthlySal=new int[12];
        int bonus=0;
        int totalSal=0;
        int totalEmployeeSal=0;
        int averageMonthlySal=0;
        int averageEmployeesSal=0;
        String salType;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of employees : ");
        noOfEmployees=validateNumberOfEmployees(sc);
        for(int i=1;i<=noOfEmployees;i++)
        {
            System.out.println("Enter the name of employee " + i + " : ");
            name = sc.next();
            System.out.println("Enter the base salary for " + name + " : ");
            baseSal = validateSal(sc,"basic");
            for (int j=0; j<12; j++)
            {
                System.out.println("Enter the salary for month " + (j+1) + " : ");
                monthlySal[j] = validateSal(sc,"monthly");
            }
            totalSal=calculateTotalSal(monthlySal);
            System.out.println("Total salary of employee " + i + " ("+name+") : "+totalSal);
            averageMonthlySal=totalSal/12;
            System.out.println("Average monthly salary : "+averageMonthlySal);
            bonus=calculateBonus(baseSal);
            System.out.println("Bonus : "+bonus);
            System.out.println();
            totalEmployeeSal+=totalSal;
        }
        averageEmployeesSal=totalEmployeeSal/noOfEmployees;
        System.out.println("Average employee salary : "+averageEmployeesSal);
        System.out.println("Thank you for using the Employee Salary Management System!");
    }

    private static int validateNumberOfEmployees(Scanner sc)
    {
        boolean validFlag = true;
        int noOfEmployees=0;
        while (validFlag)
        {
            while (!sc.hasNextInt())
            {
                System.out.println("Error, invalid input! Enter the number of employees in the range (1-50) : ");
                sc.next();
            }
            noOfEmployees = sc.nextInt();
            if (noOfEmployees < 1 || noOfEmployees > 50)
            {
                System.out.println("Error, invalid input! Enter the number of employees in the range (1-50) : ");
            } else
                validFlag = false;
        }
        return noOfEmployees;
    }

    private static int validateSal(Scanner sc, String salType)
    {
        boolean validFlag = true;
        int sal=0;
        while (validFlag)
        {
            while (!sc.hasNextInt())  //checking if salary is int
            {
                System.out.println("Error, invalid input! Enter the "+salType+" salary in the range (0-100000) : ");
                sc.next();
            }
            sal= sc.nextInt();
            if (sal<1 || sal>100000)  //checking if salary is withing the defined range
            {
                System.out.println("Error, invalid input! Enter the "+salType+" salary in the range (0-100000) : ");
            }
            else
                validFlag = false;
        }
        return sal;
    }

    private static int calculateTotalSal(int[] monthlySal)
    {
        int totalSal=0;
        for(int i=0;i<monthlySal.length;i++)
            totalSal+=monthlySal[i];
        return totalSal;
    }

    private static int calculateBonus(int basicSal)
    {
        int bonus=0;
        bonus=basicSal/10;  //10% of basic
        return bonus;
    }
}
