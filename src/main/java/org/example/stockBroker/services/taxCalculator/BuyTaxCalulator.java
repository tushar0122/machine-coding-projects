package org.example.stockBroker.services.taxCalculator;

import org.example.stockBroker.services.TransactionManager;

public class BuyTaxCalulator implements TaxCalculator {

    private static TaxCalculator taxCalculator;

    private BuyTaxCalulator() {
    }

    public static TaxCalculator getInstance(){
        if(taxCalculator == null){
            taxCalculator = new BuyTaxCalulator();
        }
        return taxCalculator;
    }

    @Override
    public double calcuateTax(double transactionAmount) {
        return 0.05*transactionAmount;
    }
}
