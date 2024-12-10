package com.quest.thread.useCaseQuestion.FileProcessing;

import java.io.*;

public class FileProcessor implements Runnable
{
    String fileName;

    public FileProcessor(String fileName)
    {
        this.fileName = fileName;
    }

    @Override
    public void run()
    {
        try
        {
            BufferedReader fileReader=new BufferedReader(new FileReader(fileName));
            String l;
            System.out.println("File content of "+fileName+" : ");
            while((l=fileReader.readLine())!=null)
            {
                System.out.println(l);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
