package org.example.stockBroker;

import java.time.LocalDateTime;

class Transaction{
    private String clientId;
    private String stockId;
    private int quantity;
    private double price;
    private double totalAmount;
    private LocalDateTime time;

    public Transaction(String stockId, String clientId, int quantity, double price, double totalAmount, LocalDateTime localDateTime) {
        this.stockId = stockId;
        this.clientId = clientId;
        this.quantity = quantity;
        this.price = price;
        this.totalAmount = totalAmount;
        this.time = localDateTime;
    }

    public String getClientId() {
        return clientId;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public String getStockId() {
        return stockId;
    }
    public double getTotalAmount() {
        return totalAmount;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
