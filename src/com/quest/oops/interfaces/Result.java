package com.quest.oops.interfaces;

public class Result implements InterfaceA, InterfaceB
{
    @Override
    public void add()
    {

    }

    @Override
    public void add1()
    {

    }

    @Override
    public void subtract()
    {

    }

    public static void main(String[] args)
    {
        Result rs=new Result();
        System.out.println("from result");
        rs.add1();
    }
}
