package org.example.archive.stockBroker.entities;

public class Stock{
    private String id;
    private String name;
    private double price;

    public Stock(String id, String name, double price) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
