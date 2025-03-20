package org.example.stockBroker.services.transactionProcessor;

import org.example.stockBroker.constants.OrderType;

public  interface TransactionProcessor {

    public void processTransaction(String clientId, String stockId, int quantity);

}
