package com.quest.java8.Streams;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class OptionalEg
{
    public static void main(String[] args)
    {
        List<String> names=new ArrayList<>(Arrays.asList("Charles","Daniel","Carlos","Lewis",null,"Max"));
        List<String> result=names.stream()
                .map(Optional::ofNullable) //wrap each element in optional
                .filter(Optional::isPresent)
                .map(name->name.get().toUpperCase())
                .toList();
        System.out.println(result);

        //using flatmap to convert to stream again
        List<String> result2=names.stream()
                .map(Optional::ofNullable)
                .flatMap(Optional::stream)
                .map(n->n.toUpperCase())
                .toList();
        System.out.println(result2);

        //using orELSE for default value
        List<String> result3=names.stream()
                .map(Optional::ofNullable)
                .map(n->n.orElse("default"))
                .map(n->n.toUpperCase())
                .toList();

        System.out.println(result3);

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter string");
        String str=sc.nextLine();
        Optional<String> strOp=Optional.ofNullable(str.isEmpty()?null:str);
        String result4=strOp.orElse("default");
        System.out.println("name : "+result4);
        if(strOp.isPresent())
        {
            Optional<String> upperCaseName=strOp.map(String::toUpperCase);
            System.out.println(upperCaseName.get());
        }


    }
}
