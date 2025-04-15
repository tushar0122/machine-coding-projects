package org.example.archive.stockBroker.services.transactionProcessor;

public  interface TransactionProcessor {

    public void processTransaction(String clientId, String stockId, int quantity) throws Exception;

}
