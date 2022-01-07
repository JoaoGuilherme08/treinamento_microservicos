package com.solinftec.training.bean;

import java.text.DecimalFormat;

public abstract class Car implements ICar {
    private static double TAX_PERCENTAGE = 0.01;

    private static final int PRINT_COLUMNS = 45;
    private static final int PRINT_PARAGRAPH_SIZE = 4;
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
        var text = """
=============================================
  Congratulations on your new car purchase!
=============================================""" + System.getProperty("line.separator");
        text += printDetailLine("Make", make);
        text += printDetailLine("Model", model);
        text += printDetailLine("Engine", "%.1f".formatted(engineSize) + " liter(s)");
        text += printDetailLine("Transmission", transmission);
        if (allTerrain) {
            text += " AWD (All Weel Drive) " + System.getProperty("line.separator");
        }
        text += printDetails();
        text += printDetailLine("Price", priceFormatter.format(price));
        text += printDetailLine("Taxes", priceFormatter.format(100 * (getTaxPercentage()-1)) + "%");
        var final_price = priceFormatter.format(price * getTaxPercentage());
        text += System.getProperty("line.separator") + printDetailLine("Final Price", final_price);
        for (int x = 0; x < PRINT_COLUMNS; x++) {
            text += "=";
        }
        return text;
    }

    protected String printDetailLine(String key, String value) {
        var line = "";
        for (int x = 0; x < PRINT_PARAGRAPH_SIZE; x++) {
            line += " ";
        }
        line += key + ": ";
        for (int x = 0, count = (PRINT_COLUMNS - line.length() - value.length()); x < count; x++) {
            line += ".";
        }
        line += value;
        return line + System.getProperty("line.separator");
    }

    protected double getTaxPercentage(){
        return 1 + TAX_PERCENTAGE;
    }

    /* printDetails() Allow decorator classes to customize
    the receipt printing.*/
    protected abstract String printDetails();
}
