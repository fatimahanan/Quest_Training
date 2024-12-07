package com.quest.cloneableInterfaceEg;

public class Address implements Cloneable
{
    private String city;
    private String country;


    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Address clonedAddress=(Address) super.clone();
        clonedAddress.setCity(new String(this.getCity()));
        clonedAddress.setCountry(new String(this.getCountry()));
        return clonedAddress;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
