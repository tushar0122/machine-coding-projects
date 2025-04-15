package org.example.archive.stockBroker.services.taxCalculator;

public class IntraDaySellTaxCalculator implements TaxCalculator {

    private static TaxCalculator taxCalculator;

    private IntraDaySellTaxCalculator() {
    }

    public static TaxCalculator getInstance(){
        if(taxCalculator == null){
            taxCalculator = new IntraDaySellTaxCalculator();
        }
        return taxCalculator;
    }

    @Override
    public double calcuateTax(double transactionAmount) {
        return 0.1*transactionAmount;
    }
}
