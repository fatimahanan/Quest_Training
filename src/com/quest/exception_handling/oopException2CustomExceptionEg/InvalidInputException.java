package com.quest.exception_handling.oopException2CustomExceptionEg;

public class InvalidInputException extends Exception
{
    public InvalidInputException(String message)  //custom checked exception
    {
        super(message);
    }
}
