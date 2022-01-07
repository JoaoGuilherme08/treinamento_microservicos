package com.solinftec.training.bean;

import com.solinftec.training.builder.CarReceiptBuilder;

public class Hatchback extends Car {
    private static double TAX_PERCENTAGE = 0.04;

    @Override
    protected double getTaxPercentage() {
        return super.getTaxPercentage() + TAX_PERCENTAGE;
    }

    @Override
    protected void printDetails(CarReceiptBuilder receiptBuilder) {   
    }
}
