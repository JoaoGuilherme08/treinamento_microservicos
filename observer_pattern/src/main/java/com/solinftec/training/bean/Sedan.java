package com.solinftec.training.bean;

import com.solinftec.training.builder.CarReceiptBuilder;

public class Sedan extends Car {
    private boolean limousine;

    public boolean isLimousine() {
        return limousine;
    }

    public void setLimousine(boolean limousine) {
        this.limousine = limousine;
    }

    @Override
    protected void printDetails(CarReceiptBuilder receiptBuilder) {
        if(limousine){
            receiptBuilder.appendDetailLine("Optionals", "Limousine size");
        }
    }
}
