package org.example.stockBroker.services.taxCalculator;

public class IntraDaySellTaxCalculator implements TaxCalculator {

    @Override
    public double calcuateTax(double transactionAmount) {
        return 0.1*transactionAmount;
    }
}
