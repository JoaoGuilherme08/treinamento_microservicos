package com.solinftec.training.bean;

public interface ICar {
    String getMake();
    void setMake(String make);
    String getModel();
    void setModel(String model);
    double getEngineSize();
    void setEngineSize(double size);
    String getTransmission();
    void setTransmission(String transmission);
    double getPrice();
    void setPrice(double price);
    boolean isAllTerrain();
    void setAllTerrain(boolean allTerrain);
    String print();
}
