package com.solinftec.training.bean;

import com.solinftec.training.builder.CarReceiptBuilder;

public class Pickup extends Car {
    private boolean isDoubleCabin;

    public Pickup(){
        this.allTerrain = true;
    }

    public boolean isDoubleCabin() {
        return isDoubleCabin;
    }

    public void setDoubleCabin(boolean isDoubleCabin) {
        this.isDoubleCabin = isDoubleCabin;
    }

    @Override
    protected void printDetails(CarReceiptBuilder receiptBuilder) {
        if(isDoubleCabin){
            receiptBuilder.appendDetailLine("Cabin size", "Double");
        } else {
            receiptBuilder.appendDetailLine("Cabin size", "Single");
        }
    }
}
