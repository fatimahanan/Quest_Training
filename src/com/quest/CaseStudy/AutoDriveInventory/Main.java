package com.quest.CaseStudy.AutoDriveInventory;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;
//
//public class Main
//{
//    public static void main(String[] args) {
//        System.out.println("Welcome to the Auto Drive Inventory");
//        Inventory i = new Inventory();
//        Map<Customer, Set<Vehicle>> customerVehicleMap = new HashMap<>();
//        Vehicle[] v = new Vehicle[5];
//        v[0] = new Car("c1", "mercedes", "g65", 100, LocalDate.of(2024, 12, 2), 5);
//        v[1] = new Car("c2", "infiniti", "qx50", 5500000, LocalDate.of(2024, 5, 24), 5);
//        v[2] = new Bike("b1", "harley davidson", "sportster", 1600000, LocalDate.of(2024, 3, 21), 1200);
//        v[3] = new Bike("b2", "royal enfield", "himalayan", 200000, LocalDate.of(2023, 12, 21), 500);
//        v[4] = new Bike("b3", "hero", "splendor", 75000, LocalDate.of(2023, 12, 21), 100);
//
//        for (Vehicle vehicle : v) {
//            i.addVehicle(vehicle);
//            System.out.println(vehicle);
//        }
//        Scanner sc = new Scanner(System.in);
//        System.out.println("\nEnter vehicle brand to search for : ");
//        String brand = sc.nextLine();
//
//        Arrays.stream(v)
//                .filter(vehicle -> vehicle.getBrand().equals(brand))
//                .forEach(vehicle -> System.out.println(vehicle));
//
//
//        Customer customer1 = new Customer("c1", "hanan", "hanan@gmail.com");
//        Customer customer2 = new Customer("c2", "lola", "lola@hotmail.com");
//
//        try {
//            i.purchaseFromInventory(customer1, "c1", customerVehicleMap);
//            i.purchaseFromInventory(customer1, "b1", customerVehicleMap);
//            i.purchaseFromInventory(customer2, "b3", customerVehicleMap);
//        } catch (VehicleNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//        System.out.println("\nCustomer 1's purchased vehicles: ");
//        for (Purchase purchase : customer1.getPurchasedVehicles()) {
//            System.out.println(purchase);
//        }
//
//        System.out.println("\nCustomer 2's purchased vehicles: ");
//        for (Purchase purchase : customer2.getPurchasedVehicles()) {
//            System.out.println(purchase);
//        }
//
////        List<Purchase> allPurchasedVehicles = Stream
////                .concat(customer1.getPurchasedVehicles().stream(), customer2.getPurchasedVehicles().stream())
////                .sorted()
////                .toList();
////
////        // print all sorted vehicles
////        System.out.println("\nAll purchased vehicles sorted by price (descending):");
////        allPurchasedVehicles.forEach(System.out::println);
//
//        // Combine all purchases and sort by price in descending order
//        List<Purchase> allPurchases = new ArrayList<>();
//        allPurchases.addAll(customer1.getPurchasedVehicles());
//        allPurchases.addAll(customer2.getPurchasedVehicles());
//
//
//        // Sort and print all purchased vehicles
//        allPurchases.stream()
//                .sorted(Comparator.comparingDouble(purchase -> purchase.getVehicle().getPrice()).reversed())
//                .forEach(purchase -> System.out.println(purchase.getVehicle() + " | Purchased at: " + purchase.getPurchaseDateTime()));
//
//
//    }
//}
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Auto Drive Inventory");
        Inventory i = new Inventory();
        Map<Customer, Set<Vehicle>> customerVehicleMap = new HashMap<>();
        Vehicle[] v = new Vehicle[5];
        v[0] = new Car("c1", "mercedes", "g65", 100, LocalDate.of(2024, 12, 2), 5);
        v[1] = new Car("c2", "infiniti", "qx50", 5500000, LocalDate.of(2024, 5, 24), 5);
        v[2] = new Bike("b1", "harley davidson", "sportster", 1600000, LocalDate.of(2024, 3, 21), 1200);
        v[3] = new Bike("b2", "royal enfield", "himalayan", 200000, LocalDate.of(2023, 12, 21), 500);
        v[4] = new Bike("b3", "hero", "splendor", 75000, LocalDate.of(2023, 12, 21), 100);

        for (Vehicle vehicle : v) {
            i.addVehicle(vehicle);
            System.out.println(vehicle);
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter vehicle brand to search for : ");
        String brand = sc.nextLine();

        Arrays.stream(v)
                .filter(vehicle -> vehicle.getBrand().equals(brand))
                .forEach(vehicle -> System.out.println(vehicle));

        Customer customer1 = new Customer("c1", "hanan", "hanan@gmail.com");
        Customer customer2 = new Customer("c2", "lola", "lola@hotmail.com");

        try {
            i.purchaseFromInventory(customer1, "c1", customerVehicleMap);
            i.purchaseFromInventory(customer1, "b1", customerVehicleMap);
            i.purchaseFromInventory(customer2, "b3", customerVehicleMap);
        } catch (VehicleNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nCustomer 1's purchased vehicles: ");
        for (Purchase purchase : customer1.getPurchasedVehicles()) {
            System.out.println(purchase);
        }

        System.out.println("\nCustomer 2's purchased vehicles: ");
        for (Purchase purchase : customer2.getPurchasedVehicles()) {
            System.out.println(purchase);
        }

        // Combine all purchases and sort by price in descending order
        List<Purchase> allPurchases = new ArrayList<>();
        allPurchases.addAll(customer1.getPurchasedVehicles());
        allPurchases.addAll(customer2.getPurchasedVehicles());

        // Sort and print all purchased vehicles by price in descending order
//        allPurchases.stream()
//                .sorted(Comparator.comparingDouble(purchase -> purchase.getVehicle().getPrice()).reversed())
//                .forEach(purchase -> System.out.println(purchase));
        System.out.println("\nSorted by price in descending order : ");
        allPurchases.stream()
                .sorted(Comparator.comparingDouble((Purchase purchase) -> purchase.getVehicle().getPrice()).reversed())
                .forEach(purchase ->
                        System.out.println(purchase.getVehicle() + " | Purchased at: " + purchase.getPurchaseDateTime()));

    }
}
