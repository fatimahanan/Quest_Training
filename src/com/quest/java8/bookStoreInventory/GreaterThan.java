package com.quest.java8.bookStoreInventory;

import java.util.List;

@FunctionalInterface
public interface GreaterThan
{
    List<String> comparePrice(Book[] b);
}
