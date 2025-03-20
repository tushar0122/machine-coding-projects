package org.example.stockBroker;

import java.util.HashMap;
import java.util.Map;

class StockBroker {
    Map<String, Client> clientData = new HashMap<String, Client>();
    Map<String, Stock> stockData = new HashMap<String, Stock>();

    public void createClient(Client client) {
        clientData.put(client.getId(), client);
    }

    public void createStock(Stock stock) {
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

    public void printClientHolding(String clientId){
        var holdings = clientData.get(clientId).getHoldings();
        for(var holding: holdings.entrySet()){
            System.out.println("Stock: "+holding.getKey()+" Quantity: "+holding.getValue());
        }
    }

    public void printAllClientHolding(){
        for(var clientId: clientData.keySet()){
            printClientHolding(clientId);
        }
    }

}
