package com.quest.Collections.stackVector;

import java.util.Stack;

public class StackEg
{
    public static void main(String[] args)
    {
        Stack<Integer> stack=new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        StackEg.displayAll(stack);
        System.out.println("\nPopped element : "+stack.pop());
        StackEg.displayAll(stack);
        System.out.println("\nPeeked element: "+stack.peek());
        StackEg.displayAll(stack);
        System.out.println("\nSearching for element 1: "+stack.search(1));
        System.out.println("\nSize of stack: "+stack.size());
    }
    private static void displayAll(Stack stack)
    {
        System.out.println("PRINTING STACK...");
        for(Object s:stack)
            System.out.println(s);
    }
}
