package org.example.archive.stockBroker.services.transactionProcessor;

import org.example.archive.stockBroker.constants.OrderType;

public class TransactionProcessorFactory {

    public static TransactionProcessor getInstance(OrderType orderType){
        switch (orderType){
            case BUY -> {
                return BuyTransactionProcessor.getInstance();
            }
            case SELL -> {
                return SellTransactionProcessor.getInstance();
            }
            default -> throw new IllegalArgumentException("Invalid OrderType");
        }
    }
}
