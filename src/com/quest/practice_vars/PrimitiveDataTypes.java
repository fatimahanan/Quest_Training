package com.quest.practice_vars;
//ASSIGNMENT2 07/11/24
public class PrimitiveDataTypes
{
    public static void main(String[] args)
    {
        byte byteType=100; //-128 to 127
        short shortType=20000; //-32678 to 32767
        int intType=300; //2^31
        long longType=250000000L;  //2^63
        float floatType=3.14f;
        double doubleType=40.89;
        
        char charType='A';
        boolean booleanType=true;
        System.out.println("byte value : "+byteType);
        System.out.println("short value : "+shortType);
        System.out.println("int value : "+intType);
        System.out.println("long value : "+longType);
        System.out.println("float value : "+floatType);
        System.out.println("double value : "+doubleType);
        System.out.println("char value : "+charType);
        System.out.println("boolean value : "+booleanType);
    }
}
