package com.quest.exception_handling.oopException2;

public class InvalidInputException extends Exception
{
    public InvalidInputException(String message)  //custom checked exception
    {
        super(message);
    }
}
