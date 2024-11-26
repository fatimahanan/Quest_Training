package com.quest.files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class StreamEg
{
    public static void main(String[] args)
    {
        try
        {
            FileInputStream fis=new FileInputStream("file1.txt");
            System.out.println("file stream created successfully");
            int c;
            while ((c=fis.read())!=-1)
            {
                System.out.print((char)c);
            }
            System.out.println();
            FileOutputStream fos=new FileOutputStream("file1.txt");
            String str="****Stream content****";
            fos.write(str.getBytes());
            fis.close();
            fos.close();
            System.out.println("file stream closed successfully");
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
