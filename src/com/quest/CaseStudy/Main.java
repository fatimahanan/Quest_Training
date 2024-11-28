package com.quest.CaseStudy;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
       SubscriberOperationsImpl s=new SubscriberOperationsImpl();

       s.addSubscriber(1,"hanan","7568893033","prepaid",500);
       s.addSubscriber(2,"john","5679871232","postpaid",300);
       s.addSubscriber(3,"liam","9979887852","prepaid",800);

       s.recordCallHistory(1,"std",50, LocalDateTime.of(2024,12,5,4,30));
       s.recordCallHistory(2,"local",70, LocalDateTime.of(2024,10,3,2,00));
       s.recordCallHistory(2,"isd",20, LocalDateTime.of(2024,12,6,3,30));
       s.recordCallHistory(3,"local",10,LocalDateTime.of(2024,12,7,23,10));


        Scanner sc=new Scanner(System.in);
        while (true)
        {
            System.out.println("\n******** Menu *********");
            System.out.println("1. Add subscriber");
            System.out.println("2. List subscribers");
            System.out.println("3. Update subscriber balance for prepaid customers");
            System.out.println("4. Record call history of subscriber");
            System.out.println("5. Display call history of subscriber");
            System.out.println("6. Generate bill for postpaid customers");
            System.out.println("7. Exit");
//            System.out.println("8. Save data");
            System.out.print("Enter your choice: ");

            int ch = sc.nextInt();
            sc.nextLine();  // Consume newline after integer input

            // Process user input based on their choice
            switch (ch)
            {
                case 1:
                    System.out.print("Enter subscriber id : ");
                    int id = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.print("Enter name : ");
                    String name = sc.nextLine();
                    System.out.print("Enter phone number : ");
                    String phoneNumber = sc.nextLine();
                    System.out.print("Enter plan type (prepaid/postpaid): ");
                    String planType = sc.nextLine();
                    System.out.print("Enter balance : ");
                    int balance = sc.nextInt();
                    s.addSubscriber(id, name, phoneNumber, planType, balance);
                    break;

                case 2:
                    s.ListAllSubscribers();
                    break;

                case 3:
                    System.out.print("Enter subscriber ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.print("Enter new balance: ");
                    int newBalance = sc.nextInt();
                    s.updateSubscriberBalancePrepaid(updateId, newBalance);
                    break;

                case 4:
                    System.out.print("Enter subscriber ID: ");
                    int subscriberId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter call type (Local/STD/ISD): ");
                    String callType = sc.nextLine();
                    System.out.print("Enter call duration in minutes: ");
                    int duration = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter timestamp (YYYY-MM-DDTHH:MM): ");
                    String timestampStr = sc.nextLine();
                    LocalDateTime timestamp = LocalDateTime.parse(timestampStr);
                    s.recordCallHistory(subscriberId, callType, duration, timestamp);
                    break;

                case 5:
                    System.out.print("Enter subscriber ID to view call history : ");
                    int subId = sc.nextInt();
                    s.displayCallHistory(subId);
                    break;

                case 6:
                    System.out.print("Enter subscriber ID: ");
                    int subId2 = sc.nextInt();
                    s.generateBillPostpaid(subId2);
                    break;

                case 7:
                    System.out.println("Exiting...");
                    return;

//                case 8:
//                    System.out.println("saving data..");
//                    s.saveData();
//                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
//       s.ListAllSubscribers();
//
//       s.displayCallHistory(1);
//       s.displayCallHistory(2);
//       s.displayCallHistory(3);
//
//       s.generateBill(1);
//       s.generateBill(2);
//       s.generateBill(3);
    }

}
