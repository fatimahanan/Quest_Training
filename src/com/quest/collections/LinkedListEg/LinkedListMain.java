package com.quest.collections.LinkedListEg;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListMain
{
    public static void main(String[] args)
    {
        LinkedList<Employee> employeeList = new LinkedList<>();
        employeeList.add(new Employee("Hanan",23,"female",45000,"IT"));
        employeeList.add(new Employee("Mike",26,"male",60000,"Sales"));
        employeeList.add(new Employee("Aida",22,"female",30000,"Logistics"));
        employeeList.addLast(new Employee("Larry",22,"male",35000,"IT"));
        employeeList.addFirst(new Employee("Saniya",26,"female",65000,"Sales"));


        System.out.println("\nPRINTING EMPLOYEE DETAILS...");
        for(Employee e : employeeList)
        {
            System.out.println(e.getName()+" : ["+e.getAge()+", "+e.getGender()+", "+e.getSalary()+", "+e.getDepartment()+"]");
        }

        System.out.println("\nPRINTING NAMES OF MALE EMPLOYEES...");
        Iterator<Employee> iterator = employeeList.iterator();
        while (iterator.hasNext())
        {
            Employee e = iterator.next();
            if(e.getGender().equals("male"))
                System.out.println(e.getName());
        }

        System.out.println("\nPRINTING NAMES OF FEMALE EMPLOYEES...");
        iterator = employeeList.iterator(); //reinitializing
        while (iterator.hasNext())
        {
            Employee e = iterator.next();
            if(e.getGender().equals("female"))
                System.out.println(e.getName());
        }

        System.out.println("\nPRINTING EMPLOYEES WITH SALARY>40000");
        iterator = employeeList.iterator();
        while (iterator.hasNext())
        {
            Employee e = iterator.next();
            if(e.getSalary() > 40000)
                System.out.println(e.getName()+" : "+e.getSalary());
        }

        System.out.println("\n4TH EMPLOYEE IN THE LIST : "+employeeList.get(3).getName());

        System.out.println("\nSIZE OF LIST : "+employeeList.size());

        employeeList.remove(3);
        System.out.println("\nREMOVING 4TH EMPLOYEE...");

        System.out.println("\nPRINTING EMPLOYEE DETAILS...");
        for(Employee e : employeeList)
        {
            System.out.println(e.getName()+" : ["+e.getAge()+", "+e.getGender()+", "+e.getSalary()+", "+e.getDepartment()+"]");
        }

        employeeList.removeLast();
        System.out.println("\nREMOVING LAST EMPLOYEE...");
        System.out.println("UPDATED SIZE OF LIST : "+employeeList.size());

        Employee firstEmp=employeeList.peekFirst();
        System.out.println("\nFirst employee : "+firstEmp.getName());

        System.out.println("\nIS THE LIST EMPTY? : "+employeeList.isEmpty());

        employeeList.clear();
        System.out.println("\nCLEARED LIST...");
        System.out.println("IS THE LIST EMPTY? : "+employeeList.isEmpty());
//        Employee aida=new Employee("Aida", 22, "female", 30000, "Logistics");
//        System.out.println("\nDOES THE LIST CONTAIN 'Aida'? : " + employeeList.contains(aida));

    }

}
