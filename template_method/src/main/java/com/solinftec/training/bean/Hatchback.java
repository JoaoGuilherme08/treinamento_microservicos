package com.solinftec.training.bean;

public class Hatchback extends Car {
    private static double TAX_PERCENTAGE = 0.04;

    @Override
    protected double getTaxPercentage() {
        return super.getTaxPercentage() + TAX_PERCENTAGE;
    }

    @Override
    protected String printDetails() {
        return "";
    }
}
