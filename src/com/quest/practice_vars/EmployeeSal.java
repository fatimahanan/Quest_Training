package com.quest.practice_vars;

import java.util.Scanner;

public class EmployeeSal
{
    public static void main(String[] args)
    {
        int noOfEmployees=0;
        Scanner sc=new Scanner(System.in);
        //accepting no of employees
        System.out.println("Enter the number of employees : ");
        noOfEmployees=validateNumberOfEmployees(sc);
        System.out.println();
        String[] name=new String[noOfEmployees];
        int[] baseSal=new int[noOfEmployees];
        int[][] monthlySal=new int[noOfEmployees][12];
        int[] bonus=new int[noOfEmployees];
        int[] totalSal=new int[noOfEmployees];
        int totalEmployeeSal=0;
        int[] averageMonthlySal=new int[noOfEmployees];
        int averageEmployeesSal=0;
        String salType;
        //accepting employee details
        for(int i=0;i<noOfEmployees;i++)
        {
            System.out.println("\nEnter the name of employee " + (i+1) + " : ");
            name[i] = sc.next();
            System.out.println("Enter the base salary for " + name[i] + " : ");
            baseSal[i] = validateBasicSal(sc,"basic");
            for (int j=0; j<12; j++)
            {
                System.out.println("Enter the salary for month " + (j+1) + " : ");
                monthlySal[i][j] = validateMonthlySalary(sc,"monthly",baseSal[i]);
            }
            totalSal[i] = calculateTotalSal(monthlySal[i]); // Calculating total salary for the employee
            averageMonthlySal[i] = totalSal[i] / 12; // Calculating average monthly salary for the employee
            bonus[i] = calculateBonus(baseSal[i]); // Calculating bonus based on basic salary
        }
        totalEmployeeSal = calculateTotalEmployeesSal(totalSal, bonus);
        averageEmployeesSal = totalEmployeeSal / noOfEmployees; // Calculate average salary across all employees
        System.out.println("------------------EMPLOYEE SALARY REPORT------------------");
        totalEmployeeSal=printSalReport(noOfEmployees,name,baseSal,monthlySal);
        averageEmployeesSal=totalEmployeeSal/noOfEmployees;
        System.out.println("----------------------------------------------------------");
        System.out.println("Average employee salary : "+averageEmployeesSal);
        System.out.println("Thank you for using the Employee Salary Management System!");
        System.out.println("----------------------------------------------------------");
    }

    private static int validateNumberOfEmployees(Scanner sc)
    {
        boolean validFlag = true;
        int noOfEmployees=0;
        while (validFlag)
        {
            while (!sc.hasNextInt())    //checking if noOfEmployees is integer
            {
                System.out.println("Error, invalid input! Enter the number of employees in the range (1-50) : ");
                sc.next();
            }
            noOfEmployees = sc.nextInt();
            if (noOfEmployees < 1 || noOfEmployees > 50)   //checking if noOfEmployees falls within the range
            {
                System.out.println("Error, invalid input! Enter the number of employees in the range (1-50) : ");
            } else
                validFlag = false;
        }
        return noOfEmployees;
    }

    private static int validateBasicSal(Scanner sc, String salType)
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
            if (sal<0 || sal>100000)  //checking if salary is withing the defined range
            {
                System.out.println("Error, invalid input! Enter the "+salType+" salary in the range (0-100000) : ");
            }
            else
                validFlag = false;
        }
        return sal;
    }

    private static int validateMonthlySalary(Scanner sc, String salType, int baseSal)
    {
        boolean validFlag=true;
        int monthlySal = 0;
        while (validFlag)
        {
            if (!sc.hasNextInt())
            {
                System.out.println("Error, invalid input! Enter the " + salType + " salary greater than the base salary (" + baseSal + "): ");
                sc.next();  //clear the invalid input
            }
            else
            {
                monthlySal = sc.nextInt();
                if (monthlySal >= baseSal)
                {
                    validFlag=false;  //if monthly salary is greater than the base salary, break the loop
                }
                else
                {
                    System.out.println("Error, the " + salType + " salary must be greater than the base salary (" + baseSal + "). Please enter again: ");
                }
            }
        }
        return monthlySal;
    }

    private static int calculateTotalSal(int[] monthlySal)
    {
        int totalSal=0;
        for(int i=0;i<monthlySal.length;i++)
            totalSal+=monthlySal[i];
        return totalSal;
    }

    private static int calculateTotalEmployeesSal(int[] totalSal, int[] bonus)
    {
        int totalEmployeeSal = 0;
        for (int i = 0; i < totalSal.length; i++)
        {
            totalEmployeeSal += totalSal[i] + bonus[i]; // Total salary + bonus for each employee
        }
        return totalEmployeeSal;
    }

    private static int calculateBonus(int basicSal)
    {
        int bonus=0;
        bonus=basicSal/10;  //10% of basic salary
        return bonus;
    }

    private static int printSalReport(int noOfEmployees, String[] name, int[] baseSal, int[][] monthlySal)
    {
        int totalSal=0;
        int averageMonthlySal=0;
        int bonus=0;
        int totalEmployeeSal=0;
        int averageEmployeesSal=0;
        for(int i=0;i<noOfEmployees;i++)
        {
            System.out.println("Employee name : " + name[i]);
            System.out.println("Base salary : " + baseSal[i]);
            System.out.println("Monthly salary breakdown : ");
            for (int j = 0; j < 12; j++)
            {
                System.out.println("Month " + (j + 1) + " : " + monthlySal[i][j]);
            }
            totalSal = calculateTotalSal(monthlySal[i]);
            System.out.println("Total salary : "+ totalSal);
            averageMonthlySal = totalSal / 12;
            System.out.println("Average monthly salary : " + averageMonthlySal);
            bonus = calculateBonus(baseSal[i]);
            System.out.println("Bonus : " + bonus);
            System.out.println();
            totalEmployeeSal += totalSal;
        }
        return totalEmployeeSal;
    }
}








