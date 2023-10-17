package com.example.spring.daytwo.tax;

public class DeveloperTax implements Taxable {
    @Override
    public double getSimpleTaxRate() {
        return 6000;
    }

    @Override
    public double getMiddleTaxRate() {
        return 12000;
    }

    @Override
    public double getUpperTaxRate() {
        return 18000;
    }


}
