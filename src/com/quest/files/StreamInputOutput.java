package com.quest.files;

import java.io.*;

public class StreamInputOutput
{
    public static void main(String[] args)
    {
        File f=new File("stream.txt");
        try
        {
            if(f.createNewFile())
            {
                System.out.println("\nFile created successfully");
                FileInputStream fis=new FileInputStream("stream1.txt");
                System.out.println("\nFile Input Stream created successfully");
                //writing
                String str="abc\ndef\nghi\njkl\nmno\n";
                FileOutputStream fos=new FileOutputStream("stream1.txt",true);
                System.out.println("\nFile Output stream created successfully");
                fos.write(str.getBytes());
                fos.close();
                System.out.println("\nContent written into file successfully");
                //reading
                int c;
                while ((c=fis.read())!=-1)
                {
                    System.out.print((char)c);
                }
                System.out.println("\nContent read successfully");
                fis.close();
            }
            else
            {
                System.out.println("File already exists...");
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
