package com.quest.practice_vars;

import java.util.Scanner;

public class EmployeeSalaryManagement
{
    public static void main(String[] args)
    {
        int noOfEmployees=0;
        String name;
        int baseSal=0;
        int[] monthlySal=new int[12];
        int bonus=0;
        int totalSal=0;
        int totalEmployeeSal=0;
        int averageMonthlySal=0;
        int averageEmployeesSal=0;
        String salType;
        Scanner sc=new Scanner(System.in);
        //accepting no of employees
        System.out.println("Enter the number of employees : ");
        noOfEmployees=validateNumberOfEmployees(sc);
        System.out.println();
        for(int i=0;i<noOfEmployees;i++)
        {
            System.out.println("Enter the name of employee " + (i+1) + " : ");
            name = sc.next();
            System.out.println("Enter the base salary for " + name + " : ");
            baseSal = validateBasicSal(sc,"basic");
            for (int j=0; j<12; j++)
            {
                System.out.println("Enter the salary for month " + (j+1) + " : ");
                monthlySal[j] = validateMonthlySalary(sc,"monthly",baseSal);
            }
            //Generating salary report
            System.out.println();
            System.out.println("-------"+name+" - Employee Salary Report-------");
            totalSal=calculateTotalSal(monthlySal);
            System.out.println("Total salary : "+totalSal);
            averageMonthlySal=totalSal/12;
            System.out.println("Average monthly salary : "+averageMonthlySal);
            bonus=calculateBonus(baseSal);
            System.out.println("Bonus : "+bonus);
            System.out.println();
            totalEmployeeSal+=totalSal;
        }
        averageEmployeesSal=totalEmployeeSal/noOfEmployees;               //calculating average sal of all employees
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
            if (noOfEmployees < 1 || noOfEmployees > 50)   //checking if noOfEmployees falls withing the range
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

    private static int calculateBonus(int basicSal)
    {
        int bonus=0;
        bonus=basicSal/10;  //10% of basic salary
        return bonus;
    }
}









/*System.out.println("------Employee Salary Report------");
        for(int i=0;i<noOfEmployees;i++)
        {
            System.out.println("Employee name : " +name);
            System.out.println("Base salary : "+baseSal);
            System.out.println("Monthly salary breakdown : ");
            for (int j=0;j<=12;j++)
            {
                System.out.print("Month "+(j+1)+" : "+monthlySal[j]+" : ");
            }
            totalSal=calculateTotalSal(monthlySal);
            System.out.println("Total salary of employee " + i + " ("+name+") : "+totalSal);
            averageMonthlySal=totalSal/12;
            System.out.println("Average monthly salary : "+averageMonthlySal);
            bonus=calculateBonus(baseSal);
            System.out.println("Bonus : "+bonus);
            System.out.println();
            totalEmployeeSal+=totalSal;
        }*/