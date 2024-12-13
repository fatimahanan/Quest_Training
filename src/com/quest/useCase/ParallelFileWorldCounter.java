package com.quest.useCase;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ParallelFileWorldCounter
{
    public static void main(String[] args)
    {
        HashMap<String,Integer> wordFreqMap=new HashMap<>();
        List<String> fileNames= Arrays.asList("file1.txt","file2.txt","file3.txt");
        List<Thread> threads = new ArrayList<>();
        for (String file : fileNames)
        {
            Thread thread = new Thread(() -> {
                countFreq(wordFreqMap,file);
            });
            threads.add(thread);

            try
            {
                thread.start();
                thread.join();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        System.out.println("\nFrequency map : ");
        wordFreqMap.entrySet()
                        .forEach(entry->System.out.println(entry.getKey()+" : "+entry.getValue()));

        System.out.println("\nTop 2:");
        wordFreqMap.entrySet().stream()
                .sorted((w1,w2)->w2.getValue().compareTo(w1.getValue()))
                .limit(2)
                .forEach(entry->System.out.println(entry.getKey()+" : "+entry.getValue()));



    }
    public synchronized static Map<String,Integer> countFreq(Map<String,Integer> wordFreqMap,String fileName)
    {
        try(BufferedReader r=new BufferedReader(new FileReader(fileName)))
        {
            String l;
            while((l= r.readLine())!=null)
            {
                String[] words=l.split(" ");
                for(String w:words)
                {
                    if(!w.isEmpty())
                    {
                        w=w.toLowerCase();
                        wordFreqMap.put(w, wordFreqMap.getOrDefault(w,0)+1);
                    }
                }
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return wordFreqMap;
    }
}
