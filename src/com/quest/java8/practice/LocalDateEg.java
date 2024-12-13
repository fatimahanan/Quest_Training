package com.quest.java8.practice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class LocalDateEg
{
    public static void main(String[] args) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("local dateTime : "+currentDateTime);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss");

        String formattedDateTime = currentDateTime.format(formatter);

        System.out.println("formatted dateTime : "+formattedDateTime);

        LocalDateTime someOtherDate = LocalDateTime.of(2023,12,4,11,35,34);
        System.out.println("someOtherDate : "+someOtherDate);

        boolean after=currentDateTime.isAfter(someOtherDate);
        System.out.println("after : "+after);

        LocalDateTime added = currentDateTime.plus(2, ChronoUnit.YEARS);
        String addedDate=added.format(formatter);
        System.out.println("added 2 years : "+addedDate);

        LocalDate date=LocalDate.now();
        System.out.println("\nlocal date : "+date);
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yy");
        System.out.println(date.format(dtf));
        String dateStr="10/02/24";
        LocalDate date1=LocalDate.parse(dateStr,dtf);  //parsing string to dateformat
        System.out.println(date1);
    }
}
