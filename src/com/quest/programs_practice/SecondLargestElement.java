package com.quest.programs_practice;

import java.util.Arrays;

public class SecondLargestElement
{
    public static void main(String[] args)
    {
          int[] arr={2, 4, 5, 7, 8};
          Arrays.sort(arr);
          int largest=arr[arr.length-1];
          int secondLargest=-1;
          for(int i=arr.length-2;i>=0;i--)
          {
              if (arr[i] < largest)
              {
                  secondLargest = arr[i];
                  break;
              }
          }
          if(secondLargest!=-1)
              System.out.println(secondLargest);

    }
}
