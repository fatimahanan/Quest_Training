package com.quest.Streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeMain
{
    public static void main(String[] args)
    {
        Employee e1=new Employee(1,"pam",50,"IT",1000000,28);
        Employee e2=new Employee(2,"lola",30,"Sales",100000,8);
        Employee e3=new Employee(3,"ken",40,"IT",500000,18);

        //sorting based on sal
        List<Employee> employeeList=List.of(e1,e2,e3);

        List<Employee> sortedBySalary=employeeList
                .stream()
                .sorted((a,b) -> Integer.compare(a.getSalary(), b.getSalary()))
                .toList();
        System.out.println("\nSorting by salary...");
        sortedBySalary.forEach(System.out::println);

        //filter employee by department
        List<Employee> itEmployees=employeeList
                .stream()
                .filter(e->e.getDepartment().equalsIgnoreCase("IT"))
                .toList();
        System.out.println("\nFiltering by Dept (IT)...");
        itEmployees.forEach(System.out::println);

        //max experience
        Optional<Employee> maxExperiencedEmployee=employeeList
                .stream()
                .distinct()
                .sorted((a,b)->Integer.compare(b.getYearsOfExperience(), a.getYearsOfExperience()))
                .findFirst();

        System.out.println("\nMost experienced : \n"+maxExperiencedEmployee.get());

        //total sal
        Optional<Integer> totalSal=employeeList
                .stream()
                .map(Employee::getSalary)
                .reduce((a,b)->a+b);
        System.out.println("\nTotal salary \n: "+totalSal.get());

        //skip first few entries for pagination
        List<Employee> skippedEmp=employeeList
                .stream()
                .skip(2)
                .toList();
        System.out.println("\nAfter skipping 2 employees : \n"+skippedEmp+"\n");


        //iterating to perform custom operation
        System.out.println("\nDoubling salaries : ");
        employeeList
                .stream()
                .map(e->{
                    e.setSalary(e.getSalary()*2);
                    return e;
                })
                .forEach(e->System.out.println(e.getName()+" - "+e.getSalary()));


        //collecting result into list/map
        List<Employee> collectedList=employeeList
                .stream()
                .toList();
        System.out.println("\nCollected employee list");
        employeeList.forEach(System.out::println);

    }
}
