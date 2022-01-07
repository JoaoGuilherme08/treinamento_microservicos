package com.solinftec.training;

import com.solinftec.training.bean.ICar;
import com.solinftec.training.observer.CarSale;
import com.solinftec.training.observer.CarSale.ICarSaleObserver;

/**
 * Hello world!
 *
 */
public class ObserverApp 
{
    public static void main( String[] args )
    {
        var carSale = new CarSale();
        carSale.addObserver(new ICarSaleObserver() {
            @Override
            public void onAddItem(ICar itemAdded) {
                System.out.println(
                    String.format("%s %s added. Total sale value is $%.2f", 
                        itemAdded.getMake(), 
                        itemAdded.getModel(), 
                        carSale.getSaleTotal()
                    )
                );
            }

            @Override
            public void onItemRemoved(ICar itemRemoved) {
                System.out.println(
                    String.format("%s %s removed. Total sale value is $%.2f",
                        itemRemoved.getMake(),
                        itemRemoved.getModel(),
                        carSale.getSaleTotal()
                    )
                );
            }
        });
        carSale.startSale();
        System.out.println(carSale.getSaleReceipt());
        System.out.println(String.format("Total sale value is $%.2f", carSale.getSaleTotal()));
    }
}
