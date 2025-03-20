package org.example.stockBroker.services;

import org.example.stockBroker.entities.Client;
import org.example.stockBroker.entities.Stock;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StockManager {
    Map<String, Stock> stockData = new ConcurrentHashMap<String, Stock>();
    private static StockManager stockManager;

    private StockManager() {
    }

    public static StockManager getInstance(){
        if(stockManager == null){
            stockManager = new StockManager();
        }
        return stockManager;
    }

    public void createStock(String stockId, String name, double price) {
        Stock stock = new Stock(stockId, name, price);
        stockData.put(stock.getId(), stock);
    }

    public Stock getStock(String stockId) {
        return stockData.get(stockId);
    }


    public void updateStockPrice(String stockId, double price) {
        var stock = stockData.get(stockId);
        stock.setPrice(price);
    }

}
