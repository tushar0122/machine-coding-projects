package org.example.stockBroker;

public class StockBrokerSystem {

    public static void main(String args[]) throws Exception {
        StockBroker broker = StockBroker.getInstance();
        broker.createClient("C1", "Ankit", 50000);
        broker.createStock("S1", "Birla", 100.0);
        broker.updateStockPrice("S1", 200.0);
        broker.printClientHoldings("C1");
        broker.processTransaction(OrderType.BUY, "C1", "S1", 10);
        broker.printClientHoldings("C1");
        broker.processTransaction(OrderType.SELL, "C1", "S1", 5);
        broker.printClientHoldings("C1");
        broker.printAllClientHoldings();
    }
}
