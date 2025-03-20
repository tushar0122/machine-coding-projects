package org.example.stockBroker.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Client{
    private String id;
    private String name;
    private double capital;
    private Map<String, Stack<Transaction>> buyTransactions = new HashMap<String, Stack<Transaction>>();
    private Map<String, Integer> holdings = new HashMap<String , Integer>();

    public Map<String, Stack<Transaction>> getBuyTransactions() {
        return buyTransactions;
    }

    public Client(String id, String name, int capital) {
        this.name = name;
        this.id = id;
        this.capital = capital;
    }

    public String getId() {
        return id;
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

}
