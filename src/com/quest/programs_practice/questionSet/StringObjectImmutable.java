package com.quest.programs_practice.questionSet;

public class StringObjectImmutable
{
    public static void main(String[] args)
    {
        String str="string";
        System.out.println(str);
        str.concat(" is mutable?");
        System.out.println("after concatenation : "+str);
        str=str.concat(" is not mutable");  //new string created
        System.out.println("after reference change : "+str);

    }
}
