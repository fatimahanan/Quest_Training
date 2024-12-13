package com.quest.useCase.AutoMobilePOS;

public class Vehicle
{
    private int id;
    private String brand;
    private String model;
    private int price;
    private int quantityInStock;

    public Vehicle(int id, String brand, String model, int price, int quantityInStock) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", quantityInStock=" + quantityInStock +
                '}';
    }

    public void updateQuantityInStock(int quantitySold)
    {
        System.out.println("\nattempting to sell...");
        if(quantitySold>quantityInStock)
        {
            System.out.println("Insufficient stock, could not sell "+quantitySold+" units of ("+id+"-"+brand+" "+model+")");
        }
        else
        {
            quantityInStock-=quantitySold;
            System.out.println("Sold "+quantitySold+" units of ("+id+"-"+brand+" "+model+")\nUpdate stock : "+quantityInStock);
        }
    }
}
