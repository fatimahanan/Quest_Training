package com.quest.programs_practice.questionSet;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class IndianDate
{
    public static void main(String[] args)
    {
        ZonedDateTime zone=ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("current time in India : "+zone);
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MMM/yy HH:mm:ss");
        String formattedDateTime=zone.format(formatter);
        System.out.println("formatted date : "+formattedDateTime);




    }
}
