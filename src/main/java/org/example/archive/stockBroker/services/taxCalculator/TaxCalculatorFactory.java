package org.example.archive.stockBroker.services.taxCalculator;

import org.example.archive.stockBroker.constants.TaxType;

public class TaxCalculatorFactory {
    public static TaxCalculator getInstance(TaxType taxType){
        switch (taxType){
            case BUY -> {
                return BuyTaxCalulator.getInstance();
            }
            case INTRADAY_SELL -> {
                return IntraDaySellTaxCalculator.getInstance();
            }
            case INTERDAY_SELL -> {
                return InterDaySellTaxCalculator.getInstance();
            }
            default -> throw new IllegalArgumentException("Invalid OrderType");
        }
    }
}
