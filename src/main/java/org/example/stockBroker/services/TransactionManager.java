package org.example.stockBroker.services;

import org.example.stockBroker.constants.OrderType;
import org.example.stockBroker.services.transactionProcessor.TransactionProcessorFactory;

public class TransactionManager {

    private static TransactionManager transactionManager;
    private ClientManager clientManager;
    private StockManager stockManager;

    private TransactionManager(ClientManager clientManager, StockManager stockManager) {
        this.clientManager = clientManager;
        this.stockManager = stockManager;
    }

    public static TransactionManager getInstance(){
        if(transactionManager == null){
            var clientManager = ClientManager.getInstance();
            var stockManager = StockManager.getInstance();
            transactionManager = new TransactionManager(clientManager, stockManager);
        }
        return transactionManager;
    }

    public void processTransaction(OrderType orderType, String clientId, String stockId, int quantity) throws Exception {
        var client = clientManager.getClient(clientId);
        var stockPrice = stockManager.getStock(stockId).getPrice();
        var transactionProcessor = TransactionProcessorFactory.getInstance(orderType);
        transactionProcessor.processTransaction(clientId, stockId, quantity);
    }
}
