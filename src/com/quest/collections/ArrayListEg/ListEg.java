package com.quest.collections.ArrayListEg;

import java.util.ArrayList;
import java.util.Iterator;

public class ListEg
{
    public static void main(String[] args)
    {
        ArrayList<Person> list = new ArrayList<Person>();
        list.add(new Person("Hanan",19));
        list.add(new Person("Harry",23));
        list.add(new Person("Shawn",24));
//        list.remove(2);
        System.out.println("Original list: ");
        for(Person person : list)
            System.out.println(person.getName()+" : "+person.getAge());
        System.out.println();
        System.out.println("List of those who have age less than 20 :  ");
        for(Person person : list)
        {
            if(person.getAge()<20)
                System.out.println(person.getName() + " : " + person.getAge());
        }
//        int harryAge=list.get(1).getAge();
//        System.out.println("age of Harry : "+harryAge);
        System.out.println("\nUsing Iterator : ");
        Iterator<Person> iterator = list.iterator();
        while (iterator.hasNext())
        {
            Person person = iterator.next();
            if(person.getAge()<20) {
                System.out.println(person.getName() + " : " + person.getAge());
            }
        }
        System.out.println();
        ArrayList<Integer> intList=new ArrayList<>();
        intList.add(5);
        intList.add(6);
        intList.add(7);
        System.out.println();
        for (int i : intList)
        {
            System.out.println(i);
        }
    }
}
