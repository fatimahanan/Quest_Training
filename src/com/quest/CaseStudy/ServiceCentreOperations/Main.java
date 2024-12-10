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
        ServiceBooking<PlatinumCustomer> b3 = new ServiceBooking<>("b3", pc1, LocalDateTime.of(2025, 10, 15, 10, 35), "wheel alignment", 500);
        ServiceBooking<NormalCustomer> b2 = new ServiceBooking<>("b2", nc1, LocalDateTime.of(2024, 12, 16, 8, 20), "replace battery", 900);

        //adding service booking list to customer
        nc1.addServiceBooking(b2);
        pc1.addServiceBooking(b1);
        pc1.addServiceBooking(b3);

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
        System.out.print("\nAll Service Bookings:");
        serviceManagement.getAllServiceBookings().forEach((customer, bookings) -> {
            System.out.println("\n" + customer.getName() + "'s service bookings :");
            bookings.forEach(System.out::println);
        });

//        // Get and display service bookings for a specific customer (e.g., Hanan)
//        System.out.println("\nService Bookings for Hanan:");
//        List<ServiceBooking> hananBookings = serviceManagement.getServiceBookingsByCustomer(pc1);
//        hananBookings.forEach(System.out::println);

//        // Look up a service booking by booking ID
//        System.out.println("\nService Booking with ID 'b2':");
//        ServiceBooking foundBooking = serviceManagement.getServiceBookingById("b2");
//        if (foundBooking != null) {
//            System.out.println(foundBooking);
//        } else {
//            System.out.println("Booking not found.");
//        }

        Predicate<ServiceBooking> serviceInNextWeek = booking -> booking.getServiceDate().isBefore(LocalDateTime.now().plusDays(7));

        System.out.println("\nServices scheduled within the next 7 days:");
        serviceManagement.getAllServiceBookings().forEach((customer, bookings) -> {
            bookings.stream().filter(serviceInNextWeek).forEach(System.out::println);
        });

        List<Customer> customers = new ArrayList<>(Arrays.asList(pc1, pc2, nc1, nc2));
        Consumer<Customer> printInvoice = customer -> {
            double totalCost = customer.getServiceBookings().stream().mapToDouble(ServiceBooking::getCost).sum();
            System.out.println("\nInvoice for " + customer.getName() + ":");
            customer.getServiceBookings().forEach(booking -> {
                System.out.println("Service ID: " + booking.getBookingId() + ", Type: " + booking.getServiceType() + ", Cost: " + booking.getCost());
            });
            System.out.println("Total Cost: " + totalCost);
        };
        System.out.println("Detailed invoice : ");
        customers.forEach(printInvoice);
//        printInvoice.accept(pc1);

        //15% discount for cuatomers more than 1 service
        Function<Customer, Double> applyDiscount = customer -> {
            int serviceCount = customer.getServiceBookings().size();
            double totalCost = customer.getServiceBookings().stream().mapToDouble(ServiceBooking::getCost).sum();
            if (serviceCount > 1)
                return 0.85 * totalCost;
            return totalCost;
        };
        System.out.println("\ndiscounted price for hanan : " + applyDiscount.apply(pc1));
        System.out.println("\ndiscounted price for rajesh : " + applyDiscount.apply(nc1));

        //generate random booking
        Supplier<ServiceBooking<?>> randomServiceBooking = () -> {
            Random random = new Random();
            String randomServiceId = "b" + random.nextInt(100);
            Customer randomCustomer = random.nextBoolean() ? pc2 : nc2;
            LocalDateTime randomServiceDate = LocalDateTime.now().plusDays(random.nextInt(30));  // Random date within the next 30 days
            String[] serviceTypes = {"oil change", "brake inspection", "battery check", "wheel alignment"};
            String randomServiceType = serviceTypes[random.nextInt(serviceTypes.length)];
            double randomCost = 100 + random.nextDouble() * 500;  // Random cost between 100 and 600
            return new ServiceBooking<>(randomServiceId, randomCustomer, randomServiceDate, randomServiceType, randomCost);
        };

        System.out.println("\nGenerated Random Service Booking: ");
        System.out.println(randomServiceBooking.get());
    }
}


