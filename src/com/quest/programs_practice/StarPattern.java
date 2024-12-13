package com.quest.programs_practice;

import java.util.Scanner;

//        *
//        **
//        ***
//        ****
//        *****
//        ****
//        ***
//        **
//        *
public class StarPattern {
    public static void main(String[] args) {
        System.out.println("Enter number of rows : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int middle = (n / 2) + 1;
        for (int i = 1; i <= middle; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = middle - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++)
                System.out.print("*");
            System.out.println();
        }
    }
}
