package org.example.archive.stockBroker.services.transactionProcessor;

import org.example.archive.stockBroker.entities.Client;
import org.example.archive.stockBroker.entities.Transaction;
import org.example.archive.stockBroker.services.ClientManager;
import org.example.archive.stockBroker.services.StockManager;

import java.time.LocalDateTime;
import java.util.Stack;

public class BuyTransactionProcessor implements TransactionProcessor {

    private static TransactionProcessor transactionProcessor;
    private ClientManager clientManager;
    private StockManager stockManager;

    private BuyTransactionProcessor(ClientManager clientManager, StockManager stockManager) {
        this.clientManager = clientManager;
        this.stockManager = stockManager;
    }

    public static TransactionProcessor getInstance(){
        if(transactionProcessor == null){
            var clientManager = ClientManager.getInstance();
            var stockManager = StockManager.getInstance();
            transactionProcessor = new BuyTransactionProcessor(clientManager, stockManager);
        }
        return transactionProcessor;
    }

    @Override
    public void processTransaction(String clientId, String stockId, int quantity) throws Exception {
        double price = stockManager.getStock(stockId).getPrice();
        Client client = clientManager.getClient(clientId);
        var capital = client.getCapital();
        double amount = price*quantity;
        double tax = amount*0.05;
        double totalAmount = amount+tax;
        if(capital>=totalAmount){
            capital -= totalAmount;
            Transaction transaction = new Transaction(stockId, clientId, quantity, price, totalAmount, LocalDateTime.now());
            client.getBuyTransactions().computeIfAbsent(stockId, k-> new Stack<Transaction>());
            client.getBuyTransactions().computeIfPresent(stockId, (a, b)-> {
                b.push(transaction);
                return b;
            });
            client.getHoldings().computeIfAbsent(stockId, k->0);
            client.getHoldings().computeIfPresent(stockId, (k, v)-> v+quantity);
            client.setCapital(capital);
        }
        else{
            throw new Exception("Insufficient Balance");
        }
    }
}
