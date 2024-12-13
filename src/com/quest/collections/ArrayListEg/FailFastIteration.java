package com.quest.collections.ArrayListEg;

import java.util.ArrayList;
import java.util.Iterator;

public class FailFastIteration
{
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
            if (element.equals("B")) {
                iterator.remove();//safe removal
            }
//            list.add("D"); //this will throw concurrent modification
        }
    }
}

