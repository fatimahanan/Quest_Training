package com.quest.exception_handling.oopException;

import java.io.IOException;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            Employee e1=new Employee(1,"Hanan",2,30000);
            Employee e2=new Employee(2,"Sandra",3,500000);
            Manager m1=new Manager(3,"John",8,300000,"Sales");
            Manager m2=new Manager(4,"Lara",9,300000,"IT");
            e1.displayDetails();
            e2.displayDetails();
            m1.displayDetails();
            m2.displayDetails();
            System.out.println("Printing job description of manager "+m1.getName());
            m1.jobDescription("manages IT section, leads a team of 20\n");
            System.out.println("Printing job description of manager "+m2.getName());
            m2.jobDescription(null);
        }
        catch(IOException e)
        {
            System.out.println("Checked exception has occurred\n"+e.getMessage());
            e.printStackTrace();
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("Unchecked exception has occurred."+e.getMessage());
            e.printStackTrace();
        }
        catch (NullPointerException e)
        {
            System.out.println("Unchecked exception has occurred."+e.getLocalizedMessage());
            e.printStackTrace();
        }
        catch (Exception e)
        {
            System.out.println("Checked exception has occurred."+e.getLocalizedMessage());
        }
        finally {
            System.exit(0); //not a good practice
            System.out.println("done.");
        }
    }
}
