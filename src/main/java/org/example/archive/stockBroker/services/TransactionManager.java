package org.example.archive.stockBroker.services;

import org.example.archive.stockBroker.constants.OrderType;
import org.example.archive.stockBroker.services.transactionProcessor.TransactionProcessorFactory;

public class TransactionManager {

    private static TransactionManager transactionManager;

    private TransactionManager() {
    }

    public static TransactionManager getInstance(){
        if(transactionManager == null){
            transactionManager = new TransactionManager();
        }
        return transactionManager;
    }

    public void processTransaction(OrderType orderType, String clientId, String stockId, int quantity) throws Exception {
        var transactionProcessor = TransactionProcessorFactory.getInstance(orderType);
        transactionProcessor.processTransaction(clientId, stockId, quantity);
    }
}
