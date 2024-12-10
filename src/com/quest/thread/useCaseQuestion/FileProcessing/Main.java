package com.quest.thread.useCaseQuestion.FileProcessing;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<String> fileNameList=new ArrayList<>();
        fileNameList.add("file1.txt");
        fileNameList.add("file2.txt");
        fileNameList.add("file3.txt");

        try
        {
            for(String fileName:fileNameList)
            {
                FileProcessor fp=new FileProcessor(fileName);
                Thread t=new Thread(fp);
                t.start();
                t.join();
                System.out.println();
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
