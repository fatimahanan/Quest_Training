package com.quest.Collections.ArrayListEg;

import java.util.ArrayList;
import java.util.Iterator;

public class ListEg2
{
    public static void main(String[] args)
    {
        ArrayList<Person2> personList = new ArrayList<>();
        personList.add(new Person2("Hanan",23,"female","India"));
        personList.add(new Person2("Rohit",43,"male","India"));
        personList.add(new Person2("Ann",14,"female","Australia"));
        personList.add(new Person2("Skyler",12,"female","France"));
        personList.add(new Person2("Shawn",34,"male","Canada"));

        System.out.println("DISPLAYING PERSONS WITH AGE<20 USING FOR EACH LOOP : ");
        for(Person2 person : personList)
        {
            if(person.getAge()<20)
                System.out.println(person.getName()+"["+person.getAge()+", "+person.getGender()+", "+person.getAddress()+"]");
        }

        System.out.println("\nDISPLAYING PERSONS WITH AGE>20 USING ITERATOR : ");
        Iterator<Person2> iterator = personList.iterator();
        while(iterator.hasNext())
        {
            Person2 person = iterator.next();
            if(person.getAge()>20)
                System.out.println(person.getName()+"["+person.getAge()+", "+person.getGender()+", "+person.getAddress()+"]");
        }




    }
}
