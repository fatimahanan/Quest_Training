package com.quest.java8.bookStoreInventory;

public class OutOfStockException extends Exception
{
    public OutOfStockException(String message)
    {
        super(message);
    }
}
