package org.example.stockBroker;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Stack;

class Client{
    private String id;
    private String name;
    private double capital;
    private Map<String, Stack<Transaction>> buyTransactions;
    private Map<String, Integer> holdings;

    public Client(String name, String id, int capital) {
        this.name = name;
        this.id = id;
        this.capital = capital;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public Map<String, Integer> getHoldings() {
        return holdings;
    }

    public void setHoldings(Map<String, Integer> holdings) {
        this.holdings = holdings;
    }

    public void buyStock(String stockId, int quantity, double price) throws Exception {
        double amount = price*quantity;
        double tax = amount*0.05;
        double totalAmount = amount+tax;
        if(this.capital>=totalAmount){
            this.capital -= totalAmount;
            Transaction transaction = new Transaction(stockId, this.id, quantity, price, totalAmount, LocalDateTime.now());
            this.buyTransactions.computeIfAbsent(stockId, k-> new Stack<Transaction>());
            this.buyTransactions.computeIfPresent(stockId, (a, b)-> {
                b.push(transaction);
                return b;
            });
            this.holdings.computeIfAbsent(stockId, k->0);
            this.holdings.computeIfPresent(stockId, (k, v)-> v+quantity);
        }
        else{
            throw new Exception("Insufficient Balance");
        }
    }

    public void sellStock(String stockId, int quantity, double price) throws Exception {
        var tempQuantity = quantity;
        if(quantity>this.holdings.get(stockId)){
            throw new Exception("Insufficient stocks to sell");
        }
        var stockTransactions = this.buyTransactions.get(stockId);
        double totalTax = 0;
        var recentStockTransaction = stockTransactions.peek();
        while (quantity>recentStockTransaction.getQuantity()){
            stockTransactions.pop();
            var holdingQuantity = recentStockTransaction.getQuantity();
            var time = recentStockTransaction.getTime();
            if(LocalDate.now().isEqual(time.toLocalDate())){
                totalTax += 0.1*(holdingQuantity*price);
            }
            else{
                totalTax += 0.05*(holdingQuantity*price);
            }
            quantity-=holdingQuantity;
            recentStockTransaction = stockTransactions.peek();
        }
        if(quantity>0){
            var holdingQuantity = recentStockTransaction.getQuantity();
            var time = recentStockTransaction.getTime();
            if(LocalDate.now().isEqual(time.toLocalDate())){
                totalTax += 0.1*(holdingQuantity*price);
            }
            else{
                totalTax += 0.05*(holdingQuantity*price);
            }
            holdingQuantity-=quantity;
            recentStockTransaction.setQuantity(holdingQuantity);
            stockTransactions.push(recentStockTransaction);
        }
        this.capital+=(tempQuantity*price-totalTax);
        this.holdings.computeIfPresent(stockId, (k, v)-> v-tempQuantity);
    }

}
