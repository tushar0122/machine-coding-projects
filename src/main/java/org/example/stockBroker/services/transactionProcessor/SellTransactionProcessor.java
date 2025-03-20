package org.example.stockBroker.services.transactionProcessor;

import org.example.stockBroker.constants.TaxType;
import org.example.stockBroker.entities.Client;
import org.example.stockBroker.entities.Transaction;
import org.example.stockBroker.services.ClientManager;
import org.example.stockBroker.services.StockManager;
import org.example.stockBroker.services.taxCalculator.TaxCalculator;
import org.example.stockBroker.services.taxCalculator.TaxCalculatorFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Stack;

public class SellTransactionProcessor implements TransactionProcessor {

    private static TransactionProcessor transactionProcessor;
    private ClientManager clientManager;
    private StockManager stockManager;

    private SellTransactionProcessor(ClientManager clientManager, StockManager stockManager) {
        this.clientManager = clientManager;
        this.stockManager = stockManager;
    }

    public static TransactionProcessor getInstance(){
        if(transactionProcessor == null){
            var clientManager = ClientManager.getInstance();
            var stockManager = StockManager.getInstance();
            transactionProcessor = new SellTransactionProcessor(clientManager, stockManager);
        }
        return transactionProcessor;
    }

    @Override
    public void processTransaction(String clientId, String stockId, int quantity) throws Exception {
        Client client = clientManager.getClient(clientId);
        double price = stockManager.getStock(stockId).getPrice();
        var tempQuantity = quantity;
        if(quantity>client.getHoldings().get(stockId)){
            throw new Exception("Insufficient stocks to sell");
        }
        var stockTransactions = client.getBuyTransactions().get(stockId);
        double totalTax = 0;
        var recentStockTransaction = stockTransactions.peek();
        while (quantity>recentStockTransaction.getQuantity()){
            var holdingQuantity = recentStockTransaction.getQuantity();
            totalTax+=calculateTax(stockTransactions, recentStockTransaction, quantity, price);
            quantity-=holdingQuantity;
            recentStockTransaction = stockTransactions.peek();
        }
        if(quantity>0){
            var holdingQuantity = recentStockTransaction.getQuantity();
            totalTax+=calculateTax(stockTransactions, recentStockTransaction, quantity, price);
            recentStockTransaction.setQuantity(holdingQuantity);
            stockTransactions.push(recentStockTransaction);
        }
        client.setCapital(client.getCapital()+(tempQuantity*price-totalTax));
        client.getHoldings().computeIfPresent(stockId, (k, v)-> v-tempQuantity);
    }

    public double calculateTax(Stack<Transaction>stockTransactions, Transaction recentStockTransaction, int quantity, double price){
        stockTransactions.pop();
        var holdingQuantity = recentStockTransaction.getQuantity();
        var time = recentStockTransaction.getTime();
        var taxType = getTaxType(time);
        TaxCalculator taxCalculator = TaxCalculatorFactory.getInstance(taxType);
        holdingQuantity-=quantity;
        return taxCalculator.calcuateTax(holdingQuantity*price);
    }
    public TaxType getTaxType(LocalDateTime transactionTime){
        if(LocalDate.now().isEqual(transactionTime.toLocalDate())){
            return TaxType.INTRADAY_SELL;
        }
        return TaxType.INTERDAY_SELL;
    }
}
