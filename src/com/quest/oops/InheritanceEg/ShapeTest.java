package com.quest.oops.InheritanceEg;

public class ShapeTest
{
    public static void main(String[] args)
    {
        Shape s=new Shape();
        s.displayShape();
        System.out.println("Area of square  = "+s.calculateArea());
        System.out.println("-------------------------");
        Square sq=new Square(5);
        sq.displayShape();
        sq.displaySquare();
        System.out.println("Area of square  = "+sq.calculateArea());
    }
}
