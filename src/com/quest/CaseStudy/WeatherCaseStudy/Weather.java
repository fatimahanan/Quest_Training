package com.quest.CaseStudy.WeatherCaseStudy;

import java.util.ArrayList;

public class Weather implements WeatherOperations
{
    //list of the weather of each city
    private ArrayList<CityWeather> cityWeatherList;


    public Weather(ArrayList<CityWeather> cityWeatherList) {
        this.cityWeatherList = new ArrayList<>();
    }

    @Override
    public void addWeather(CityWeather city)
    {
        cityWeatherList.add(city);
    }

    @Override
    public void updateWeather(String cityName, Double currentTemperature, Double humidityPercentage, String weatherCondition)
    {
        for(CityWeather c : cityWeatherList)
        {
            if(c.getCityName().equalsIgnoreCase(cityName))
            {
                if (currentTemperature!=null)
                {
                    c.setCurrentTemperature(currentTemperature);
                }
                if(humidityPercentage!=null)
                {
                    c.setHumidityPercentage(humidityPercentage);
                }
                if(weatherCondition!=null)
                {
                    c.setWeatherCondition(weatherCondition);
                }
            }
        }
    }

    @Override
    public void displayDetailsAllCities()
    {
        for(CityWeather c : cityWeatherList)
        {
            System.out.println(c.toString());
        }
    }

    @Override
    public void displayDetailsCity(String cityName)
    {
        for(CityWeather c : cityWeatherList)
        {
            if(c.getCityName().equalsIgnoreCase(cityName))
            {
                System.out.println(c.toString());
                return;
            }
        }
        System.out.println(cityName+" city not found!");  //executed if city not present in list
    }

    @Override
    public String findHottestCity()
    {
        CityWeather hottestCity = cityWeatherList.get(0); //first city temperature
        for (CityWeather c : cityWeatherList)
        {
            if(c.getCurrentTemperature()> hottestCity.getCurrentTemperature())
            {
                hottestCity = c;
            }
        }
        return hottestCity.getCityName();
    }


    @Override
    public String findColdestCity()
    {
        CityWeather coldestCity = cityWeatherList.get(0); //first city temperature
        for (CityWeather c : cityWeatherList)
        {
            if(c.getCurrentTemperature()<coldestCity.getCurrentTemperature())
            {
                coldestCity = c;
            }
        }
        return coldestCity.getCityName();
    }

    @Override
    public double calculateAverageCurrentTemperature()
    {
        double sum = 0;
        for (CityWeather c : cityWeatherList)
        {
            sum += c.getCurrentTemperature();
        }
        return sum/(cityWeatherList.size());
    }

    public void displayHumidCities()
    {
        boolean found=false;
        for (CityWeather c : cityWeatherList)
        {
            if(c.getHumidityPercentage()>80.00)
            {
                System.out.println(c.getCityName());
                found=true;
            }
        }
        if(!found)
            System.out.println("No humid cities (>80%) found!");
    }

    @Override
    public void generateReport()
    {
        ArrayList<CityWeather> sunnyCities=new ArrayList<>();
        ArrayList<CityWeather> rainyCities=new ArrayList<>();
        ArrayList<CityWeather> cloudyCities=new ArrayList<>();
        ArrayList<CityWeather> otherCities=new ArrayList<>();
        for (CityWeather c : cityWeatherList)
        {
            if(c.getWeatherCondition().equalsIgnoreCase("sunny"))
            {
                sunnyCities.add(c);
            }
            else if(c.getWeatherCondition().equalsIgnoreCase("rainy"))
            {
                rainyCities.add(c);
            }
            else if(c.getWeatherCondition().equalsIgnoreCase("cloudy"))
            {
                cloudyCities.add(c);
            }
            else
            {
                otherCities.add(c);
            }
        }
        System.out.println("\nSunny cities : ");
        for(CityWeather c : sunnyCities)
        {
            System.out.print(c.getCityName()+" ");
        }
        System.out.println();
        System.out.println("\nRainy cities : ");
        for(CityWeather c : rainyCities)
        {
            System.out.print(c.getCityName()+" ");
        }
        System.out.println();
        System.out.println("\nCloudy cities : ");
        for(CityWeather c : cloudyCities)
        {
            System.out.print(c.getCityName()+" ");
        }
        System.out.println();
        System.out.println("\nOthers : ");
        for (CityWeather c : otherCities)
        {
            System.out.print(c.getCityName()+" ");
        }
    }

    @Override
    public void displayAlert()
    {
        for (CityWeather c : cityWeatherList)
        {
            if(c.getCurrentTemperature()>40)
            {
                System.out.println("Warning!!! Heat wave alert for city "+c.getCityName());
            }
            if(c.getHumidityPercentage()<20)
            {
                System.out.println("Warning!!! Low humidity in city "+c.getCityName());
            }
        }
    }

}
