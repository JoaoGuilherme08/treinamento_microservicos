package com.solinftec.training.bean;

import com.solinftec.training.builder.CarReceiptBuilder;

public class SUV extends Car{

    public SUV(){
        this.allTerrain = true;
    }

    @Override
    protected void printDetails(CarReceiptBuilder receiptBuilder) {}
}
