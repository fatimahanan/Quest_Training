package com.quest.oops.CaseStudyWeather;

public interface WeatherOperations
{
    void addWeather(City c);
    void updateWeather(String cityName,Double currentTemp,Double currentHumidity, String weatherCondition);
    void displayDetailsAllCities();
    void displayDetailsCity(String cityName);
    String findHottestCity();
    String findColdestCity();
    void displayHumidCities();
    double calculateAverageCurrentTemperature();
    void generateReport();
    void displayAlert();
}
