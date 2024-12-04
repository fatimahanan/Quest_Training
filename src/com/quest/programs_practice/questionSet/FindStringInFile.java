package com.quest.programs_practice.questionSet;

import java.io.*;

public class FindStringInFile
{
    public static void main(String[] args)
    {
        File f=new File("fileEg.txt");
        try
        {
            if(!f.exists())
            {
                if (f.createNewFile())
                    System.out.println("file created.");
            }
            else
            {
                System.out.println("file exists");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        String findString="hello";
        try(BufferedReader reader=new BufferedReader(new FileReader(f))) {
            String line;
            boolean found=false;
            while((line = reader.readLine()) !=null)
            {
                if(line.contains(findString))
                {
                    found=true;
                    System.out.println("found : "+line);
                }
            }
            if(!found)
            {
                System.out.println("not found");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
