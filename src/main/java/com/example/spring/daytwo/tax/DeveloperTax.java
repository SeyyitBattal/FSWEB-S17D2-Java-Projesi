package com.example.spring.daytwo.tax;

public class DeveloperTax implements Taxable {
    @Override
    public double getSimpleTaxRate() {
        return 0.20;
    }

    @Override
    public double getMiddleTaxRate() {
        return 0.30;
    }

    @Override
    public double getUpperTaxRate() {
        return 0.40;
    }


}
