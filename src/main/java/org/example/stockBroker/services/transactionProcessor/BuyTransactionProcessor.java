package org.example.stockBroker.services.transactionProcessor;

public class BuyTransactionProcessor implements TransactionProcessor {

    private static TransactionProcessor transactionProcessor;

    private BuyTransactionProcessor() {
    }

    public static TransactionProcessor getInstance(){
        if(transactionProcessor == null){
            transactionProcessor = new BuyTransactionProcessor();
        }
        return transactionProcessor;
    }

    @Override
    public void processTransaction(String clientId, String stockId, int quantity) {

    }
}
