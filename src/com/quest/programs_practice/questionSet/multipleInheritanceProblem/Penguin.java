package com.quest.programs_practice.questionSet.multipleInheritanceProblem;

public class Penguin implements AllAnimal,SwimmingAnimal
{

    @Override
    public void eat()
    {
        System.out.println("penguins eats fishes ");
    }

    @Override
    public void sound()
    {
        System.out.println("penguin chirps");

    }

    @Override
    public void swim()
    {
        System.out.println("penguins can swim");
    }
}
