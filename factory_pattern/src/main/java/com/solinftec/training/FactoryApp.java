package com.solinftec.training;

import java.util.ArrayList;
import java.util.Scanner;

import com.solinftec.training.bean.ICar;
import com.solinftec.training.exception.InvalidCarException;
import com.solinftec.training.factory.CarSimpleFactory;

/**
 * Hello world!
 *
 */
public class FactoryApp 
{
    public static void main( String[] args )
    {
        int choice = 0;
        try (var inputScanner = new Scanner(System.in)) {
            var carArray = new ArrayList<ICar>();
            var carFactory = new CarSimpleFactory();
            while(true) {
                System.out.println("""
                Choose a car, press 0 to end purchase:
                1 - Hyunday Azera
                2 - Toyota Hilux
                3 - Mitsubishi Pajero Sport
                4 - Chevrolet Onix
                5 - Lincoln Town Car""");
                choice = inputScanner.nextInt();
                if(choice != 0) {
                    try {
                        carArray.add(carFactory.makeCar(choice));
                    } catch (InvalidCarException e) {
                        System.out.println("You have chosen a wrong type of car. Try again");
                    }
                } else {
                    break;
                }
            }
            carArray.forEach(t -> System.out.println(t.print()));
        }
    }
}
