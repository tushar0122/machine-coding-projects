package org.example.archive.stockBroker;

import org.example.archive.stockBroker.constants.OrderType;
import org.example.archive.stockBroker.services.ClientManager;
import org.example.archive.stockBroker.services.TransactionManager;
import org.example.archive.stockBroker.services.StockManager;

public class StockBrokerSystem {

    public static void main(String args[]) throws Exception {
        ClientManager clientManager = ClientManager.getInstance();
        StockManager stockManager = StockManager.getInstance();
        TransactionManager transactionManager = TransactionManager.getInstance();
        clientManager.createClient("C1", "Ankit", 50000);
        stockManager.createStock("S1", "Birla", 100.0);
        stockManager.updateStockPrice("S1", 200.0);
        clientManager.printClientHoldings("C1");
        transactionManager.processTransaction(OrderType.BUY, "C1", "S1", 10);
        clientManager.printClientHoldings("C1");
        transactionManager.processTransaction(OrderType.SELL, "C1", "S1", 5);
        clientManager.printClientHoldings("C1");
        clientManager.printAllClientHoldings();
    }
}
