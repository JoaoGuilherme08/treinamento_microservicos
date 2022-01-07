package com.solinftec.training.bean;

public class SportsHatchback extends Hatchback  {
    private static double TAX_PERCENTAGE = 0.1;

    @Override
    protected double getTaxPercentage() {
        return super.getTaxPercentage() + TAX_PERCENTAGE;
    }    

    @Override
    protected String printDetails() {
        return printDetailLine("Optional", "Recaro seats");
    }
}
