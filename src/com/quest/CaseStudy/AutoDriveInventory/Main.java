package com.quest.CaseStudy.AutoDriveInventory;

import java.time.LocalDate;
import java.util.*;

import static com.quest.CaseStudy.AutoDriveInventory.Serialization.loadData;
import static com.quest.CaseStudy.AutoDriveInventory.Serialization.saveData;

public class Main
{
    public static void main(String[] args)
    {
        Map<Customer,Set<Vehicle>> customerVehicleMap=loadData();
        System.out.println("Welcome to the Auto Drive Inventory");
        Inventory i = new Inventory();
        if(customerVehicleMap.isEmpty())
            customerVehicleMap = new HashMap<>();
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
//        System.out.println("\nEnter vehicle brand to search for : ");
//        String brand = sc.nextLine();
//
//        Arrays.stream(v)
//                .filter(vehicle -> vehicle.getBrand().equals(brand))
//                .forEach(vehicle -> System.out.println(vehicle));

        Customer customer1 = new Customer("customer1", "hanan", "hanan@gmail.com");
        Customer customer2 = new Customer("customer2", "lola", "lola@hotmail.com");

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

        System.out.println("\nSorted by price in descending order : ");
        allPurchases.stream()
                .sorted(Comparator.comparingDouble((Purchase purchase) -> purchase.getVehicle().getPrice()).reversed())
                .forEach(purchase ->
                        System.out.println(purchase.getVehicle() + " | Purchased at: " + purchase.getPurchaseDateTime()));
//
//        saveData(customerVehicleMap);
//        System.out.println("\nSerialized...");
//
//        // Deserialize and print the data
//        System.out.println("\nDeserializing...");
//        Map<Customer, Set<Vehicle>> deserializedData = loadData();
//
//        if (deserializedData != null)
//        {
//            deserializedData.forEach((customer, vehicles) ->
//            {
//                System.out.println("Customer: " + customer.getName());
//                vehicles.forEach(vehicle ->
//                {
//                    System.out.println("Vehicle: " + vehicle.getBrand() + " " + vehicle.getModel() + " | Price: " + vehicle.getPrice());
//                });
//            });
//        }

        int ch;
        while(true)
        {
            System.out.println("\nWELCOME TO AUTODRIVE INVENTORY : ");
            System.out.println("1. Add vehicle");
            System.out.println("2. Get Vehicle by id");
            System.out.println("3. Display all vehicles");
            System.out.println("4. Purchase vehicle");
            System.out.println("5. Save data and Exit");
            System.out.println("Enter choice : ");
            ch = sc.nextInt();
            switch (ch)
            {
                case 1: //add vehicle
                    System.out.println("Enter vehicle id : ");
                    sc.nextLine();
                    String vehicleId=sc.nextLine();
                    System.out.println("Enter vehicle brand : ");
                    String vehicleBrand=sc.nextLine();
                    System.out.println("Enter vehicle model : ");
                    String vehicleModel=sc.nextLine();
                    System.out.println("Enter vehicle price : ");
                    int vehiclePrice=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter vehicle purchase date : ");
                    LocalDate vehiclePurchaseDate=LocalDate.parse(sc.nextLine());
                    i.addVehicle(new Vehicle(vehicleId, vehicleBrand, vehicleModel, vehiclePrice, vehiclePurchaseDate));
                    break;
                case 2: //get vehicle by id
                    System.out.println("Enter vehicle id : ");
                    sc.nextLine();
                    vehicleId=sc.nextLine();
                    Vehicle vehicleToGet=i.getVehicleById(vehicleId);
                    if(vehicleToGet!=null)
                        System.out.println(vehicleToGet.toString());
                    else
                        System.out.println("Vehicle not found");
                    break;
                case 3: //display
                    System.out.println("Displaying all vehicles...");
                    i.displayInventory();
                    break;
                case 4: //purchase vehicle
                    System.out.println("Enter customer id : ");
                    sc.nextLine();
                    String customerId=sc.nextLine();
                    System.out.println("Enter customer name : ");
                    String customerName=sc.nextLine();
                    System.out.println("Enter customer email : ");
                    String customerEmail=sc.nextLine();
                    Customer customer=null;
                    for(Customer c: customerVehicleMap.keySet())
                    {
                        if(c.getCustomerId().equals(customerId))
                            customer=c;
                        break;
                    }
                    if(customer==null) //new customer
                    {
                         customer=new Customer(customerId, customerName, customerEmail);
                    }
                    System.out.println("Enter details of vehicle to be purchased...");
                    System.out.println("Enter vehicle id : ");
                    String vehicleIdToBuy=sc.nextLine();
                    if(customerVehicleMap.get(customer).contains(vehicleIdToBuy))
                    {
                        System.out.println("Vehicle already purchased");
                        return;
                    }
                    try
                    {
                        i.purchaseFromInventory(customer,vehicleIdToBuy,customerVehicleMap);
                    }
                    catch (VehicleNotFoundException e)
                    {
                        throw new RuntimeException(e);
                    }
                    break;
                case 5:
                    saveData(customerVehicleMap);
                    System.out.println("\nSerialized...");
                    System.out.println("\nDeserializing...");
                    Map<Customer, Set<Vehicle>> deserializedData = loadData();

                    if (deserializedData != null)
                    {
                        deserializedData.forEach((cust, vehicles) ->
                        {
                            System.out.println("Customer: " + cust.getName());
                            vehicles.forEach(vehicle ->
                            {
                                System.out.println("Vehicle: " + vehicle.getBrand() + " " + vehicle.getModel() + " | Price: " + vehicle.getPrice());
                            });
                            System.out.println();
                        });
                    }
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
