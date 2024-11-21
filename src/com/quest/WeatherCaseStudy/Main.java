package com.quest.WeatherCaseStudy;

import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        CityWeather c1=new CityWeather("New York",22.5,65.0,"sunny");
        CityWeather c2=new CityWeather("Tokyo",18.0,80.0,"rainy");
        CityWeather c3=new CityWeather("Dubai",43.0,25.0,"sunny");
        CityWeather c4=new CityWeather("Mumbai",34.0,82.5,"rainy");
        CityWeather c5=new CityWeather("Melbourne",12.5,65.0,"cloudy");
        CityWeather c6=new CityWeather("LA",18.0,80.0,"cloudy");


        ArrayList<CityWeather> citiesList=new ArrayList<>();
        Weather w=new Weather(citiesList);

        w.addWeather(c1);
        w.addWeather(c2);
        w.addWeather(c3);
        w.addWeather(c4);
        w.addWeather(c5);

        Scanner sc=new Scanner(System.in);
        int ch;
        do {
            System.out.println("\n*****************Weather Monitoring System Menu********************");
            System.out.println("1. Display details of all cities");
            System.out.println("2. Display city details by name");
            System.out.println("3. Find hottest city");
            System.out.println("4. Find coldest city");
            System.out.println("5. Display cities with humidity > 80%");
            System.out.println("6. Generate report (display cities by weather condition)");
            System.out.println("7. Display Alerts");
            System.out.println("8. Update City Weather");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();
            sc.nextLine();
            switch (ch) {
                case 1:
                    w.displayDetailsAllCities();
                    break;

                case 2:
                    System.out.print("Enter city name to display details : ");
                    String cityName = sc.nextLine();
                    w.displayDetailsCity(cityName);
                    break;

                case 3:
                    System.out.println("Hottest city: " + w.findHottestCity());
                    break;

                case 4:
                    System.out.println("Coldest city: " + w.findColdestCity());
                    break;

                case 5:
                    w.displayHumidCities();
                    break;

                case 6:
                    w.generateReport();
                    break;

                case 7:
                    w.displayAlert();
                    break;

                case 8:
                    System.out.print("Enter city name to update: ");
                    String updateCity = sc.nextLine();
                    System.out.print("Enter new temperature: ");
                    double temp = sc.nextDouble();
                    System.out.print("Enter new humidity: ");
                    double humidity = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter new weather condition: ");
                    String condition = sc.nextLine();
                    w.updateWeather(updateCity, temp, humidity, condition);
                    break;

                case 9:
                    System.out.println("Exiting the system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }

        } while (ch!= 9);

        sc.close();
    }
}

