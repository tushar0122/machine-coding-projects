package org.example.archive.stockBroker.services.taxCalculator;

public class InterDaySellTaxCalculator implements TaxCalculator {

    private static TaxCalculator taxCalculator;

    private InterDaySellTaxCalculator() {
    }

    public static TaxCalculator getInstance(){
        if(taxCalculator == null){
            taxCalculator = new InterDaySellTaxCalculator();
        }
        return taxCalculator;
    }


    @Override
    public double calcuateTax(double transactionAmount) {
        return 0.05*transactionAmount;
    }
}
