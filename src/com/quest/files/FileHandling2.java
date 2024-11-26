package com.quest.files;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandling2
{
    public static void main(String[] args)
    {
        try
        {
            FileWriter f=new FileWriter("fileWriter1.txt");
            f.write("Hi, this is the first example of fileWriter");
            f.append("\nappended...");
            CharSequence c=new CharSequence() {
                @Override
                public int length() {
                    return 0;
                }

                @Override
                public char charAt(int index) {
                    return 0;
                }

                @Override
                public CharSequence subSequence(int start, int end) {
                    return null;
                }

                @Override
                public String toString()
                {
                    return "\ntesting char sequence object...\n";
                }
            };
            f.append(c);
            f.append("fatima hanan",7,12);
            f.close();  //if not closed, it can cause issues
            System.out.println("File written successfully");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
