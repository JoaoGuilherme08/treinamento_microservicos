package com.solinftec.training.observer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import com.solinftec.training.bean.ICar;
import com.solinftec.training.exception.InvalidCarException;
import com.solinftec.training.factory.CarSimpleFactory;

//Essa classe é o que chamamos de Observable
public class CarSale {
    private List<ICar> carArray = null;
    private Set<ICarSaleObserver> observers = new HashSet<>();

    public void startSale(){
        carArray = new ArrayList<>();
        int choice = 0;
        try (var inputScanner = new Scanner(System.in)) {
            var carFactory = new CarSimpleFactory();
            System.out.println("""
                Choose a car, press
                    0 to finish sale
                    9 to remove last car:
                1 - Hyunday Azera
                2 - Toyota Hilux
                3 - Mitsubishi Pajero Sport
                4 - Chevrolet Onix
                5 - Lincoln Town Car""");
            while (true) {
                choice = inputScanner.nextInt();
                if (choice == 9){
                    if(carArray.size() > 0){
                        notifyCarRemoved(carArray.remove(carArray.size() - 1));
                    }
                } else if (choice == 0){
                    break;
                } else {
                    try {
                        var car = carFactory.makeCar(choice);
                        carArray.add(car);
                        notifyCarAdded(car);
                    } catch (InvalidCarException e) {
                        System.out.println("You have chosen a wrong type of car. Try again");
                    }
                }
            }
        }
    }

    public void addObserver(ICarSaleObserver observer){
        observers.add(observer);
    }
    
    private void notifyCarAdded(ICar itemAdded) {
        observers.forEach(t -> t.onAddItem(itemAdded));
    }

    private void notifyCarRemoved(ICar itemRemoved) {
        observers.forEach(t -> t.onItemRemoved(itemRemoved));
    }

    public Double getSaleTotal(){
        return carArray.stream().map(ICar::getPriceWithTaxes).reduce(0D, Double::sum);
    }

    public String getSaleReceipt(){
        return carArray.stream().map(t -> t.print()).collect(Collectors.joining(System.getProperty("line.separator")));
    }
    
    public static interface ICarSaleObserver {
        void onAddItem(ICar itemAdded);
        void onItemRemoved(ICar itemRemoved);
    }
}