package com.solinftec.training.bean;

import java.text.DecimalFormat;

import com.solinftec.training.builder.CarReceiptBuilder;

public abstract class Car implements ICar {
    private static double TAX_PERCENTAGE = 0.01;
    private static final DecimalFormat priceFormatter = new DecimalFormat("0.00");

    protected String make;
    protected String model;
    protected double engineSize;
    protected String transmission;
    protected double price;
    protected boolean allTerrain;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(double engineSize) {
        this.engineSize = engineSize;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAllTerrain() {
        return allTerrain;
    }

    public void setAllTerrain(boolean allTerrain) {
        this.allTerrain = allTerrain;
    }

    public String print() {
        var builder = new CarReceiptBuilder()
            .appendHeader()
            .appendDateLine()
            .appendDetailLine("Make", make)
            .appendDetailLine("Model", model)
            .appendDetailLine("Engine", "%.1f".formatted(engineSize) + " liter(s)")
            .appendDetailLine("Transmission", transmission);

        if (allTerrain) {
            builder.appendParagraphLine("Your vehicle is equipped with AWD (All wheel Drive capability) "
                + "please be aware that in order to flat tow your vehicle you have to disengage the 4x4 "
                + "features first or else it will cause permanent damage to the car transmission.");
        }
        
        return builder
            .appendDetailLine("Price", priceFormatter.format(price))
            .appendDetailLine("Taxes", priceFormatter.format(100 * (getTaxPercentage() - 1)) + "%")
            .appendLineBreak()
            .appendDetailLine("Final Price", priceFormatter.format(price * getTaxPercentage()))
            .appendFooter()
            .build();
    }

    protected double getTaxPercentage(){
        return 1 + TAX_PERCENTAGE;
    }

    protected abstract void printDetails(CarReceiptBuilder receiptBuilder);
}
