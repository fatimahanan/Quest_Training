package com.quest.CaseStudy.TelecomSubscriber;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SubscriberOperationsImpl s = new SubscriberOperationsImpl();
        s.loadData();
//

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n******** Menu *********");
            System.out.println("1. Add subscriber");
            System.out.println("2. Remove subscriber");
            System.out.println("3. List subscribers");
            System.out.println("4. Update subscriber balance for prepaid customers");
            System.out.println("5. Record call history of subscriber");
            System.out.println("6. Display call history of subscriber");
            System.out.println("7. Generate bill for postpaid customers");
            System.out.println("8. Exit");
//            System.out.println("8. Save data");
            System.out.print("Enter your choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    int addId = subscriberIdValidation(sc);
                    sc.nextLine();
                    System.out.print("Enter name : ");
                    String name = sc.nextLine();
                    System.out.print("Enter phone number : ");
                    String phoneNumber = sc.nextLine();
                    PlanType planType = planTypeValidation(sc); //plan type
                    System.out.print("Enter balance : ");
                    int balance = sc.nextInt();
                    s.addSubscriber(addId, name, phoneNumber, planType, balance);
                    break;

                case 2:
                    int removeId=subscriberIdValidation(sc);
                    s.removeSubscriber(removeId);
                    break;

                case 3:
                    s.ListAllSubscribers();
                    break;

                case 4:
                    int updateId = subscriberIdValidation(sc);
                    sc.nextLine();
                    System.out.print("Enter new balance: ");
                    int newBalance = sc.nextInt();
                    s.updateSubscriberBalancePrepaid(updateId, newBalance);
                    break;

                case 5:
                    int addRecordId = subscriberIdValidation(sc);
                    sc.nextLine();
                    CallType callType = callTypeValidation(sc);
                    System.out.print("Enter call duration in minutes: ");
                    int duration = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter timestamp (YYYY-MM-DDTHH:MM): ");
                    String timestampStr = sc.nextLine();
                    LocalDateTime timestamp = LocalDateTime.parse(timestampStr);
                    s.recordCallHistory(addRecordId, callType, duration, timestamp);
                    break;

                case 6:
                    int subId = subscriberIdValidation(sc);
                    s.displayCallHistory(subId);
                    break;

                case 7:
                    int subId2 = subscriberIdValidation(sc);
                    s.generateBillPostpaid(subId2);
                    break;

                case 8:
                    System.out.println("Saving data and exiting...");
                    s.saveData();
                    return;

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

    private static CallType callTypeValidation(Scanner sc) {
        CallType callType = null;
        while (callType == null) {
            System.out.print("Enter call type (Local/STD/ISD): ");
            String callTypeStr = sc.nextLine().trim().toUpperCase();
            try {
                callType = CallType.valueOf(callTypeStr);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid call type, enter again...  ");
            }
        }
        return callType;
    }

    private static PlanType planTypeValidation(Scanner sc) {
        PlanType planType = null;
        while (planType == null) {
            System.out.print("Enter plan type (Prepaid/Postpaid): ");
            String planTypeStr = sc.nextLine().trim().toUpperCase();
            try {
                planType = PlanType.valueOf(planTypeStr);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid call type, enter again... ");
            }
        }
        return planType;
    }

    private static int subscriberIdValidation(Scanner sc)
    {
        int subscriberId = 0;
        System.out.print("Enter subscriber ID: ");
        while (subscriberId < 1)
        {
            while (!sc.hasNextInt())
            {
                System.out.println("Invalid subscription ID. Please try again.");
                sc.next();
            }
            subscriberId = sc.nextInt();
        }
        return subscriberId;
    }
}
