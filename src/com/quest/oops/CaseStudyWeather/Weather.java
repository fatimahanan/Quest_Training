package com.quest.oops.CaseStudyWeather;

import java.util.ArrayList;

public class Weather implements WeatherOperations
{
    //list of the weather of each city
    private ArrayList<City> cityWeatherList;


    public Weather(ArrayList<City> cityWeatherList) {
        this.cityWeatherList = new ArrayList<>();
    }

    @Override
    public void addWeather(City city)
    {
        cityWeatherList.add(city);
    }

    @Override
    public void updateWeather(String cityName, Double currentTemperature, Double humidityPercentage, String weatherCondition)
    {
        for(City c : cityWeatherList)
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
                    c.getWeatherCondition();
                }
            }
        }
    }

    @Override
    public void displayDetailsAllCities()
    {
        for(City c : cityWeatherList)
        {
            System.out.println(c.toString());
        }
    }

    @Override
    public void displayDetailsCity(String cityName)
    {
        for(City c : cityWeatherList)
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
        City hottestCity = cityWeatherList.get(0); //first city temperature
        for (City c : cityWeatherList)
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
        City coldestCity = cityWeatherList.get(0); //first city temperature
        for (City c : cityWeatherList)
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
        for (City c : cityWeatherList)
        {
            sum += c.getCurrentTemperature();
        }
        return sum/(cityWeatherList.size());
    }

    public void displayHumidCities()
    {
        boolean found=false;
        for (City c : cityWeatherList)
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
        ArrayList<City> sunnyCities=new ArrayList<>();
        ArrayList<City> rainyCities=new ArrayList<>();
        ArrayList<City> cloudyCities=new ArrayList<>();
        ArrayList<City> otherCities=new ArrayList<>();
        for (City c : cityWeatherList)
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
        System.out.println("Sunny cities : "+sunnyCities);
        System.out.println("Rainy cities : "+rainyCities);
        System.out.println("Cloudy cities : "+cloudyCities);
        System.out.println("Others : "+otherCities);
    }

    @Override
    public void displayAlert()
    {
        for (City c : cityWeatherList)
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
