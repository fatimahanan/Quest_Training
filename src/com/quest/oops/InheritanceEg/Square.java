package com.quest.oops.InheritanceEg;

public class Square extends Shape
{
    int side;
    public Square(int side)
    {
        this.side = side;
    }
    public void displaySquare()
    {
        System.out.println("\nSquare of side " +side+"cm");
    }

    @Override
    public void displayShape()
    {
        super.displayShape();
        System.out.println("Shape : square");
    }

    @Override
    public int calculateArea()
    {
        return side*side;
    }
}
