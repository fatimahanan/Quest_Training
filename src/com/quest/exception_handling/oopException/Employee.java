package com.quest.exception_handling.oopException;

import java.io.IOException;

public class Employee
{
    private int id;
    private String name;
    private int grade;
    private int salary;


    public Employee(int id, String name, int grade, int salary) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        setSalary(salary);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getSalary()
    {
        if(salary<0)  //unchecked exception
        {
            throw new IllegalArgumentException("\nSalary cannot be negative");
        }
        return salary;
    }

    public void setSalary(int salary)
    {
        this.salary = salary;
    }

    public void displayDetails() throws IOException
    {
        System.out.println();
        if(this.salary>400000)   //unchecked
            throw new IOException(this.name+"'s salary exceeds 400000, invalid.");
        System.out.println("ID :"+id);
        System.out.println("Name: " + name);
        System.out.println("Grade: " + grade);
        System.out.println("Salary: " + salary);
    }
}
