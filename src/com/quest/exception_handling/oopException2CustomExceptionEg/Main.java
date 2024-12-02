package com.quest.exception_handling.oopException2CustomExceptionEg;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Employee emp =null;
        while(emp ==null)
        {
            try
            {
                System.out.print("Enter name : ");
                String name = sc.nextLine();
                System.out.print("Enter age : ");
                int age = sc.nextInt();
                System.out.print("Enter salary : ");
                double salary = sc.nextDouble();
                sc.nextLine();
                emp =new Employee(name,age,salary);
                emp.displayMethod();
            }
            catch (InputMismatchException e)
            {
                System.out.println("Invalid input, enter correct values.");
                sc.nextLine();
            }
            catch (InvalidInputException e)
            {
                System.out.println("\nException has occurred\n"+e.getMessage());
            }
        }
        Manager m=null;
        while(m==null)
        {
            try
            {
                System.out.print("\nEnter manager name : ");
                String name = sc.nextLine();
                System.out.print("Enter age : ");
                Integer age = sc.nextInt();  //integer to primitive unboxing
                sc.nextLine();
                System.out.print("Enter salary : ");
                double salary = sc.nextDouble();
                sc.nextLine();
                System.out.print("Enter team size : ");
                int teamSize = sc.nextInt();
                sc.nextLine();

                m=new Manager(name,age,salary,teamSize);
                m.displayMethod();
                System.out.println(m);
            }
            catch (InputMismatchException e)
            {
                System.out.println("Invalid input, enter correct values.");
                sc.nextLine();
            }
            catch (InvalidInputException | IllegalArgumentException e)
            {
                System.out.println("\nException has occurred\n"+e.getMessage());
            }
        }
    }
}
