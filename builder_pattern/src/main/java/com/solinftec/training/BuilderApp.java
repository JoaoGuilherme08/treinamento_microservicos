package com.solinftec.training;

import com.solinftec.training.bean.SportsHatchback;

/**
 * Hello world!
 *
 */
public class BuilderApp 
{
    public static void main( String[] args )
    {
        var golf = new SportsHatchback();
        golf.setMake("Volkswagen");
        golf.setModel("Golf GTI");
        golf.setEngineSize(2.0);
        golf.setPrice(250000);
        golf.setTransmission("7 speed automatic DSG");
        golf.setAllTerrain(true);
        System.out.println(golf.print());
    }
}
