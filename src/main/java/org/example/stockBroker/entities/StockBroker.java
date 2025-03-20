package org.example.stockBroker.entities;

import org.example.stockBroker.entities.Stock;
import org.example.stockBroker.constants.OrderType;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public  class StockBroker {
    Map<String, Client> clientData = new ConcurrentHashMap<String, Client>();
    Map<String, Stock> stockData = new ConcurrentHashMap<String, Stock>();

    private static StockBroker stockBroker;

    private StockBroker() {
    }

    public static StockBroker getInstance(){
        if(stockBroker == null){
            stockBroker = new StockBroker();
        }
        return stockBroker;
    }

    public void createClient(String clientId, String clientName, int capital) {
        Client client = new Client(clientId, clientName, capital);
        clientData.put(client.getId(), client);
    }

    public void createStock(String stockId, String name, double price) {
        Stock stock = new Stock(stockId, name, price);
        stockData.put(stock.getId(), stock);
    }

    public void updateStockPrice(String stockId, double price) {
        var stock = stockData.get(stockId);
        stock.setPrice(price);
    }

    public void processTransaction(OrderType orderType, String clientId, String stockId, int quantity) throws Exception {
        var client = clientData.get(clientId);
        var stockPrice = stockData.get(stockId).getPrice();
        if(orderType.equals(OrderType.BUY)){
            client.buyStock(stockId, quantity, stockPrice);
        }
        else{
            client.sellStock(stockId, quantity, stockPrice);
        }
    }

    public void printClientHoldings(String clientId){
        var holdings = clientData.get(clientId).getHoldings();
        for(var holding: holdings.entrySet()){
            System.out.println("Stock: "+holding.getKey()+" Quantity: "+holding.getValue());
        }
    }

    public void printAllClientHoldings(){
        for(var clientId: clientData.keySet()){
            printClientHoldings(clientId);
        }
    }

}
