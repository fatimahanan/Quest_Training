package com.quest.CaseStudy.ServiceCentreOperations;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ElectricVehicle ev1 = new ElectricVehicle("ev1", "bmw", "iX3", 2022, 52000, "hanan", 80000, 90, 400);
        ElectricVehicle ev2 = new ElectricVehicle("ev2", "bmw", "i5", 2020, 40000, "lala", 900000, 80, 450);
        CombustionEngineVehicle cev1 = new CombustionEngineVehicle("cev1", "bmw", "x1", 2014, 20000, "rajesh", 75000, "diesel", 1995);
        CombustionEngineVehicle cev2 = new CombustionEngineVehicle("cev2", "bmw", "M4", 2024, 10000, "john", 82000, "petrol", 2995);

        ServiceCentre<ElectricVehicle> electricVehicleServiceCentre = new ServiceCentre<>();
        ServiceCentre<CombustionEngineVehicle> combustionEngineVehicleServiceCentre = new ServiceCentre<>();

        electricVehicleServiceCentre.addServicedVehicle(ev1);
        electricVehicleServiceCentre.addServicedVehicle(ev2);
        combustionEngineVehicleServiceCentre.addServicedVehicle(cev1);
        combustionEngineVehicleServiceCentre.addServicedVehicle(cev2);

        System.out.println("\nServiced electric vehicles : ");
        for (ElectricVehicle ev : electricVehicleServiceCentre.getAllServicedVehicles()) {
            System.out.println(ev);
        }

        System.out.println("\nServiced combustion engine vehicles : ");
        for (CombustionEngineVehicle cev : combustionEngineVehicleServiceCentre.getAllServicedVehicles()) {
            System.out.println(cev);
        }

        ArrayList<Vehicle> vehicleList = new ArrayList<>(Arrays.asList(ev1, ev2, cev1, cev2));

        //using predicate to filter based on mileage and year
        Predicate<Vehicle> mileageAbove50000 = v -> v.getMileage() > 50000;
        System.out.println("\nVehicles with mileage>50000 : ");
        vehicleList.stream().filter(mileageAbove50000).forEach(System.out::println);

        Predicate<Vehicle> yearBefore2015 = v -> v.getYear() < 2015;
        System.out.println("\nVehicles manufactured before 2015 : ");
        vehicleList.stream().filter(yearBefore2015).forEach(System.out::println);

        //consumer to print vehicle details in a custom format
        Consumer<Vehicle> displayVehicles = v ->
                System.out.println("vin : " + v.getVin() + ", mileage : " + v.getMileage());

        System.out.println("\nDisplaying vehicles in a custom format : ");
        vehicleList.forEach(displayVehicles);

        //supplier to generate random vehicle
        Supplier<Vehicle> generateRandomElectricVehicle = () -> {
            Random randomVehicle = new Random();
            return new ElectricVehicle("ev" + randomVehicle.nextInt(50), "bmw", "i" + randomVehicle.nextInt(9), 2024, randomVehicle.nextInt(60000), "randomName", randomVehicle.nextDouble(90000), randomVehicle.nextInt(50), randomVehicle.nextInt(8000));
        };
        System.out.println("\nGenerating random EV :\n" + generateRandomElectricVehicle.get());

        Supplier<Vehicle> generateRandomCombustionEngineVehicle = () -> {
            Random randomVehicle = new Random();
            return new CombustionEngineVehicle("cev" + randomVehicle.nextInt(50), "bmw", "X" + randomVehicle.nextInt(8), 2024, randomVehicle.nextInt(70000), "randomName", randomVehicle.nextDouble(80000), randomVehicle.nextBoolean() ? "petrol" : "diesel", randomVehicle.nextInt(3000));
        };
        System.out.println("\nGenerating random CEV : \n" + generateRandomCombustionEngineVehicle.get());

        //function to calculate resale value of vehicle based on mileage and year
        Function<Vehicle, Double> calculateResale = v -> {
            double originalPrice = v.getOriginalPrice();
            double depreciationRate = 0.02;
            int yearsUsed = LocalDate.now().getYear() - v.getYear();
            return originalPrice - (depreciationRate * yearsUsed);
        };

        System.out.println("\nResale price for vehicles : ");
        vehicleList.forEach(v -> {
            System.out.println(v.getVin() + " - original price : " + v.getOriginalPrice() + " - resale price : " + calculateResale.apply(v));
        });

        //oldest vehicle in the stream
        Optional<Vehicle> oldestVehicle = vehicleList.stream().min(Comparator.comparing(Vehicle::getYear));
        System.out.println("Oldest vehicle : " + oldestVehicle.get());

        //group vehicles by type and print count
        Map<String, Long> typeCountMap = vehicleList.stream().collect(Collectors.groupingBy(v -> v instanceof ElectricVehicle ? "electric vehicle" : "combustion engine vehicle", Collectors.counting()));
        System.out.println("\nType count map : ");
        for (Map.Entry<String, Long> entry : typeCountMap.entrySet()) {
            String type = entry.getKey();
            Long count = entry.getValue();
            System.out.println(type + " : " + count);
        }

        //creating customers
        PlatinumCustomer pc1 = new PlatinumCustomer("pc1", "hanan", "hanan@gmail.com", ev1, 580);
        PlatinumCustomer pc2 = new PlatinumCustomer("pc2", "lala", "lala@gmail.com", ev2, 600);
        NormalCustomer nc1 = new NormalCustomer("nc1", "rajesh", "rajesh@gmail.com", cev1, "normal");
        NormalCustomer nc2 = new NormalCustomer("nc2", "john", "john@hotmail.com", cev2, "normal");

        //create service booking
        ServiceBooking<PlatinumCustomer> b1 = new ServiceBooking<>("b1", pc1, LocalDateTime.of(2024, 12, 15, 10, 30), "oil change", 100);
        ServiceBooking<PlatinumCustomer> b3 = new ServiceBooking<>("b3", pc1, LocalDateTime.of(2024, 12, 15, 10, 35), "wheel alignment", 500);
        ServiceBooking<NormalCustomer> b2 = new ServiceBooking<>("b2", nc1, LocalDateTime.of(2025, 01, 25, 8, 20), "replace battery", 900);

//        //customer-service booking map
//        System.out.println("\nservices done for customer : ");
//        Map<Customer, List<ServiceBooking>> customerServiceMap = new HashMap<>();

//        customerServiceMap.putIfAbsent(pc1, new ArrayList<>());
//        customerServiceMap.putIfAbsent(pc2, new ArrayList<>());

//        customerServiceMap.get(pc1).add(b1);
//        customerServiceMap.get(pc1).add(b3);
//        customerServiceMap.get(pc2).add(b2);

        ServiceManagement serviceManagement = new ServiceManagement();

        // Adding bookings and handling exceptions
        try {
            serviceManagement.addServiceBooking(b1);
            serviceManagement.addServiceBooking(b2);
            serviceManagement.addServiceBooking(b3);
        } catch (InvalidBookingException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Get and display all service bookings
        System.out.println("\nAll Service Bookings:");
        serviceManagement.getAllServiceBookings().forEach((customer, bookings) -> {
            System.out.println(customer.getName() + " has the following bookings:");
            bookings.forEach(System.out::println);
        });

        // Get and display service bookings for a specific customer (e.g., Hanan)
        System.out.println("\nService Bookings for Hanan:");
        List<ServiceBooking> hananBookings = serviceManagement.getServiceBookingsByCustomer(pc1);
        hananBookings.forEach(System.out::println);

        // Look up a service booking by booking ID
        System.out.println("\nService Booking with ID 'b2':");
        ServiceBooking foundBooking = serviceManagement.getServiceBookingById("b2");
        if (foundBooking != null) {
            System.out.println(foundBooking);
        } else {
            System.out.println("Booking not found.");
        }
    }
}


