package org.example.stockBroker.taxCalculator;

public class InterDaySellTaxCalculator implements TaxCalculator {
    @Override
    public double calcuateTax(double transactionAmount) {
        return 0.05*transactionAmount;
    }
}
