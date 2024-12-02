package com.quest.java8.bookStoreInventory;

import java.util.ArrayList;
import java.util.List;

public class GreaterThanImpl implements GreaterThan
{
    List<String> greaterThanLimit=new ArrayList<>();

    @Override
    public List<String> comparePrice(Book[] b)
    {
        for(Book book:b)
        {
            if(book.getPrice()>45)
                greaterThanLimit.add(book.getTitle());
        }
        return greaterThanLimit;
    }
}
