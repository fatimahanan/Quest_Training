package com.quest.exception_handling.oopException;

import java.io.IOException;

public class Manager extends Employee
{
    String department;

    public Manager(int id, String name, int grade, int salary, String department)
    {
        super(id, name, grade, salary);
        this.department = department;
    }


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public void displayDetails() throws IOException
    {
       super.displayDetails();
       System.out.println("Department : " + department);
       System.out.println();
    }

    public void jobDescription(String jd)
    {
        if(jd==null || jd.equals(""))
        {
            throw new NullPointerException("Job description cannot be null");
        }
        else
        {
            System.out.println("Job Description : " + jd);
        }
    }
}
