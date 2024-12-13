package com.quest.files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TryWithoutResources
{
    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader reader=new BufferedReader(new FileReader("file1.txt"));
        try
        {
            String l;
            while((l= reader.readLine())!=null)
            {
                System.out.println(l);
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        finally {
            try
            {
                reader.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }
}
