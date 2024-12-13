package com.quest.files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources
{
    public static void main(String[] args) {
        try(BufferedReader r=new BufferedReader(new FileReader("file1.txt")))
        {
            String l;
            while((l= r.readLine())!=null)
                System.out.println(l);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
