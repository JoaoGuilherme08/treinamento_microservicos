package com.solinftec.training.bean;

import com.solinftec.training.builder.CarReceiptBuilder;

public class SportsHatchback extends Hatchback  {
    private static double TAX_PERCENTAGE = 0.1;

    @Override
    protected double getTaxPercentage() {
        return super.getTaxPercentage() + TAX_PERCENTAGE;
    }

    @Override
    protected void printDetails(CarReceiptBuilder receiptBuilder) {
        receiptBuilder.appendDetailLine("Optional", "Recaro seats");
    }    
}
