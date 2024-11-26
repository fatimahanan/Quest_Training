
package com.quest.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class CreationDeletion
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File f=new File("file2.txt");
        try
        {
            if(f.createNewFile() || f.exists())
            {
                System.out.println("File created successfully");
            }
            else
            {
                System.out.println("File might already exist, could not create file..");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(f.delete())
                System.out.println("File deleted successfully");
//            else
//                System.out.println("File could not be deleted.");

        }
    }
}
