package com.quest.Collections;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


public class PropertiesEg
{
    public static void main(String[] args) {
        Properties properties=new Properties();
        properties.setProperty("url","jdbc:oracle:thin:@localhost:1521:orcl");
        properties.setProperty("username","root");
        properties.setProperty("pass","pass123");
        FileOutputStream fos=null;
        try
        {
            fos=new FileOutputStream("config.properties");
            properties.store(fos,"config");
            System.out.println("properties saved in file");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(fos!=null)
            {
                try
                {
                    fos.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }

        Properties loadedprop=new Properties();
        try(FileInputStream fis=new FileInputStream("config.properties"))
        {
            loadedprop.load(fis);
            System.out.println("properties loaded from file");
            System.out.println("url : "+loadedprop.getProperty("url"));
            System.out.println("user : "+loadedprop.getProperty("username"));
            System.out.println("pass : "+loadedprop.getProperty("pass"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
