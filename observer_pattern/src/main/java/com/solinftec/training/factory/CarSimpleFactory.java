package com.solinftec.training.factory;

import com.solinftec.training.bean.Hatchback;
import com.solinftec.training.bean.ICar;
import com.solinftec.training.bean.Pickup;
import com.solinftec.training.bean.SUV;
import com.solinftec.training.bean.Sedan;
import com.solinftec.training.exception.InvalidCarException;

public class CarSimpleFactory {
    public ICar makeCar(int carType) throws InvalidCarException {
        ICar car = null;
        switch(carType){
            case 1:
                car = new Sedan();
                car.setEngineSize(3.0);
                car.setMake("Hyunday");
                car.setModel("Azera");
                car.setPrice(200000);
                car.setTransmission("8 speed automatic");
                break;
            case 2:
                car = new Pickup();
                car.setEngineSize(2.8);
                car.setMake("Toyota");
                car.setModel("Hilux");
                car.setPrice(250000);
                car.setTransmission("6 speed manual");
                break;
            case 3:
                car = new SUV();
                car.setEngineSize(2.4);
                car.setMake("Mitsubishi");
                car.setModel("Pajero Sport");
                car.setPrice(350000);
                car.setTransmission("8 speed automatic");
                break;
            case 4:
                car = new Hatchback();
                car.setEngineSize(1.0);
                car.setMake("Chevrolet");
                car.setModel("Onix");
                car.setPrice(90000);
                car.setTransmission("6 speed manual");
                break;
            case 5:
                car = new Sedan();
                car.setEngineSize(4.6);
                car.setMake("Lincoln");
                car.setModel("Town car");
                car.setPrice(500000);
                car.setTransmission("7 speed automatic");
                break;
            default:
                throw new InvalidCarException();
        }
        return car;
    }   
}
