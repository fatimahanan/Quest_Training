package com.quest.useCase.employee;

import java.util.*;
import java.util.stream.Collectors;

public class Main
{
    public static void main(String[] args) {

        Employee e1=new Employee(1,"hanan","IT",5000);
        Employee e2=new Employee(2,"charles","sales",8000);
        Employee e3=new Employee(3,"daniel","IT",4000);
        Employee e4=new Employee(4,"george","marketing",7000);
        Employee e5=new Employee(5,"ollie","sales",3000);
        ArrayList<Employee> employeeList=new ArrayList<>(Arrays.asList(e1,e2,e3,e4,e5));
        Map<String, List<Employee>> deptEmpMap=employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println("\nEmployees from each dept : ");
        for(Map.Entry<String,List<Employee>> entry : deptEmpMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        List<Employee> filteredSet=employeeList.stream()
                .filter(emp -> emp.getSalary() > 5000)
                .sorted(Comparator.comparing(Employee::getName))
                .toList();
        System.out.println("\nEmployees w salary>5000 and sorted by names\n"+filteredSet);

        Optional<Employee> highestSalEmployee = employeeList.stream()
                .max(Comparator.comparing(Employee::getSalary));
        System.out.println("\nEmployee with highest salary : \n"+highestSalEmployee);
    }
}
