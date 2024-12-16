package com.quest.logical;

public class reverseArray
{
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        int left=0;
        int right=arr.length-1;
        for(int i=0;i< arr.length;i++)
        {
            int temp=arr[left];
            arr[left]=arr[right];
            
        }
    }
}
