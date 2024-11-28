package com.quest.files;

import java.io.*;

public class Buffered
{
    public static void main(String[] args)
    {
        String str="Hello World";
        try
        {
            BufferedInputStream bi =new BufferedInputStream(new FileInputStream("file2.txt"));
            BufferedOutputStream bo=new BufferedOutputStream(new FileOutputStream("destination.txt"));
            byte[] buf=new byte[1024];
            int c;
            while((c=bi.read())!=-1)
            {
                System.out.print((char)c);
                bo.write(buf,0,c);
            }
            bo.flush();
            bi.close();
            bo.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
