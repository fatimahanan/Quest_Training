package com.quest.files;

import java.io.*;

public class OutputObject
{
    public static void main(String[] args)
    {
        try
        {
            String str="***content of file***";
            BufferedOutputStream bo=new BufferedOutputStream(new FileOutputStream("file3.txt",true));
            bo.write(str.getBytes());
            System.out.println("buffer data added successfully");
            BufferedInputStream bi=new BufferedInputStream(new FileInputStream("file3.txt"));
            int c;
            byte[] buf=new byte[1024];
            while((c=bi.read())!=-1)
            {
                bo.write(buf,0,c);
            }
            bo.write(str.getBytes());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
