package com.quest.Collections.Example.Example1;

import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<Person> personArrayList=new ArrayList<>();
        LinkedHashSet<Person> personLinkedHashSet=new LinkedHashSet<>();
        HashMap<Person,String> personHashMap=new HashMap<>();
        PriorityQueue<Student> personPriorityQueue=new PriorityQueue<>();


        Student s1=new Student(1,"hanan");
        Student s2=new Student(3,"rohit");
        Student s3=new Student(2,"john");

        Student1 ss1=new Student1("james",90);
        Student1 ss2=new Student1("ken",80);
        Student1 ss3=new Student1("pam",70);
        Student1 ss4=new Student1("alen",92);

        Comparator<Student1> test=Comparator.comparing(Student1::getMarks);
        Comparator<Student1> test2=(sss1,sss2)->Integer.compare(sss1.getMarks(),sss2.getMarks());
        PriorityQueue<Student1> personPriorityQueue2=new PriorityQueue<>(test2);

        personPriorityQueue2.add(ss1);
        personPriorityQueue2.add(ss2);
        personPriorityQueue2.add(ss3);
        personPriorityQueue2.add(ss4);

        for(Student1 student1:personPriorityQueue2)
        {
            System.out.println(student1.getName());
        }



        Person p1=new Person(1,"Hanan",23,"female");
        Person p2=new Person(5,"Pam",33,"female");
        Person p3=new Person(4,"James",25,"male");
        Person p4=new Person(2,"Jack",30,"male");
        Person p5=new Person(1,"James",25,"male");
        Person p6=new Person(3,"Jim",37,"male");


        personArrayList.add(p1);
        personArrayList.add(p2);
        personArrayList.add(p3);
        personArrayList.add(p4);
        personArrayList.add(p5);
        personArrayList.add(p6);

        personLinkedHashSet.add(p1);
        personLinkedHashSet.add(p2);
        personLinkedHashSet.add(p3);
        personLinkedHashSet.add(p4);
        personLinkedHashSet.add(p5);
        personLinkedHashSet.add(p6);

        personHashMap.put(p1,"IT");
        personHashMap.put(p2,"Sales");
        personHashMap.put(p3,"Development");
        personHashMap.put(p4,"Sales");
        personHashMap.put(p5,"Sales");
        personHashMap.put(p6,"IT");


        personPriorityQueue.add(s1);
        personPriorityQueue.add(s2);
        personPriorityQueue.add(s3);

//        personPriorityQueue.add(new Person(1,"Hanan",23,"female"));
//        personPriorityQueue.add(p2);
//        personPriorityQueue.add(p3);
//        personPriorityQueue.add(p4);
//        personPriorityQueue.add(p5);
//        personPriorityQueue.add(p6);

        System.out.println("\nARRAY LIST");
        for(Person p : personArrayList)
        {
            System.out.println(p);
        }

        System.out.println("\nLINKED HASH SET");
        for(Person p : personLinkedHashSet)
        {
            System.out.println(p);
        }

        System.out.println("\nHASH MAP");
        for(Map.Entry<Person,String> e : personHashMap.entrySet())
        {
            System.out.println(e.getKey()+" : "+e.getValue());
        }

        System.out.println("\nPRIORITY QUEUE");
        for(Student s : personPriorityQueue)
        {
            System.out.println(s.getId());
        }

        while(!personPriorityQueue.isEmpty())
        {
            System.out.println(personPriorityQueue.poll());
        }

        System.out.println("***");
        while(!personPriorityQueue2.isEmpty())
        {
            System.out.println(personPriorityQueue2.poll());
        }

        System.out.println(personPriorityQueue.size());

    }
}
