package com.quest.practice_vars;
//ASSIGNMENT1 07/11/24
public class StringFunctions
{
    public static void main(String[] args)
    {
        String str1="Testing";
        String str2="Code";
        String str3="Code";
        String str4="Coke";
        String str5="coke";
        String str6="co";
        String str7="Welcome back xyz Welcome";
        String str8="  Hello ";
        System.out.println("Character at 3rd position : "+str1.charAt(2));                                                   //charAt
        System.out.println("Concatenation of "+str1+" and "+str2+" is : "+str1.concat(str2));                                //concat
        System.out.println("Comparing "+str2+" and "+str3+" : "+str2.compareTo(str3));                                       //compareTo
        System.out.println("Comparing "+str3+" and "+str4+" : "+str3.compareTo(str4));
        System.out.println("Comparing "+str4+" and "+str5+" : "+str4.compareTo(str5));
        System.out.println("Comparing "+str4+" and "+str5+" (Ignoring case) : "+str4.compareToIgnoreCase(str5));             //compareToIgnoreCase
        System.out.println("Checking if content of "+str2+" equals 'Code' : "+str2.contentEquals("Code"));               //contentEquals
        System.out.println("Checking if "+str5+" contains "+str6+" : "+str5.contains(str6));                                 //contains
        System.out.println("Checking if "+str5+" ends with 'ke' : "+str5.endsWith("ke"));                                    //endsWith
        System.out.println("Checking if "+str5+" starts with 'Co' : "+str5.startsWith("Co"));
        System.out.println("Converting "+str5+" to uppercase : "+str5.toUpperCase());
        System.out.println("Converting "+str4+" to lowercase : "+str4.toLowerCase());
        char[] arr=str4.toCharArray();
        System.out.println("Converting "+str4+" to a character array and printing first character: "+arr[0]);
        System.out.println("Trimming '"+str8+"' : "+str8.trim());
        System.out.println("Length of "+str6+" : "+str6.length());
        System.out.println("Replacing 'k' with 'd' in "+str2+" : "+str2.replace('d', 'k'));
        System.out.println("Replacing 'Welcome' with 'Go' : "+str2+" : "+str7.replaceAll("Welcome", "Go"));
        System.out.println("First occurence of 'Welcome' : "+str7.indexOf("Welcome"));
        System.out.println("Last occurence of 'Welcome' : "+str7.lastIndexOf("Welcome"));
        String[] words=str7.split("\\s+");
        System.out.println("Splitting string - "+str7);
        for(String word:words)
            System.out.println(word);
    }

}
