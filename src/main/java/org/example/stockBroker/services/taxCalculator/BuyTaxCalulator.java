package org.example.stockBroker.services.taxCalculator;

public class BuyTaxCalulator implements TaxCalculator {
    @Override
    public double calcuateTax(double transactionAmount) {
        return 0.05*transactionAmount;
    }
}
