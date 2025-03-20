package org.example.stockBroker.services.transactionProcessor;

public class SellTransactionProcessor implements TransactionProcessor {

    private static TransactionProcessor transactionProcessor;

    private SellTransactionProcessor() {
    }

    public static TransactionProcessor getInstance(){
        if(transactionProcessor == null){
            transactionProcessor = new SellTransactionProcessor();
        }
        return transactionProcessor;
    }

    @Override
    public void processTransaction(String clientId, String stockId, int quantity) {

    }
}
