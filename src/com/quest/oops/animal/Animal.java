package com.quest.oops.animal;

public abstract class Animal
{
    public abstract void sound();
    public abstract void produce();
    public abstract void eat();
    public void sleep()
    {
        System.out.println("Animal is sleeping");
    }

    public static class Cow extends Animal
    {
        @Override
        public void sound()
        {
            System.out.println("Moo...");
        }

        @Override
        public void produce()
        {
            System.out.println("Cow milk collected.");
        }

        @Override
        public void eat()
        {
            System.out.println("Eating grass");
        }

        @Override
        public void sleep()
        {
            System.out.println("Cow is sleeping");
        }
    }

    public static class Hen extends Animal
    {
        @Override
        public void sound()
        {
            System.out.println("Cluck...");
        }

        @Override
        public void produce()
        {
            System.out.println("Eggs collected.");
        }

        @Override
        public void eat()
        {
            System.out.println("Eating grains");
        }

        @Override
        public void sleep()
        {
            System.out.println("Hen is sleeping");
        }
    }

    public static class Main
    {
        public static void main(String[] args)
        {
            Animal[] animals = new Animal[2];
            animals[0]=new Cow();
            animals[1]=new Hen();
            for(Animal a:animals)
            {
                a.sound();
                a.produce();
                a.sleep();
                a.eat();
                System.out.println();
            }
        }
    }
}

