package com.quest.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileHandling
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File f=new File("file.txt");
        try
        {
           if(f.createNewFile())
            {
                System.out.println("File created");
            }
            else
            {
                System.out.println("File already exists");
            }
            if(f.exists())
            {
                Scanner sc=new Scanner(f);
                if(!sc.hasNextLine())
                {
                    System.out.println("ERROR! File does not contain any content");
                }
                else
                {
                    while(sc.hasNextLine())
                    {
                        String line=sc.nextLine();
                        System.out.println(line);
                    }
                }
                sc.close();
            }
            else
            {
                System.out.println("File does not exist");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
//        finally
//        {
//            if(f.delete())
//                System.out.println("File deleted successfully");
//            else
//                System.out.println("File could not be deleted since it does not exist");
//        }
    }
}
