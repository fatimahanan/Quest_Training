package com.quest.CaseStudy.WeatherCaseStudy;

public class CityWeather
{
    private String cityName;
    private double currentTemperature;
    private double humidityPercentage;
    private String weatherCondition;

    public CityWeather(String cityName, double currentTemperature, double humidityPercentage, String weatherCondition) {
        this.cityName = cityName;
        this.currentTemperature = currentTemperature;
        this.humidityPercentage = humidityPercentage;
        this.weatherCondition = weatherCondition;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public double getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public double getHumidityPercentage() {
        return humidityPercentage;
    }

    public void setHumidityPercentage(double humidityPercentage) {
        this.humidityPercentage = humidityPercentage;
    }

    public String getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    @Override
    public String toString()
    {
        return "City : [cityName=" + cityName + ", currentTemperature=" + currentTemperature + ", humidityPercentage="+humidityPercentage+"]";
    }
}
