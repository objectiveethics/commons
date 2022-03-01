/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volgyerdo.commons.math.probability;

import java.util.Random;

/**
 *
 * @author Volgyerdo Nonprofit Kft.
 */
public abstract class Distribution {

    protected static final Random RANDOM = new Random();
    public final double meanValue;
    public final double standardDeviation;

    public Distribution(double meanValue, double standardDeviation) {
        this.meanValue = meanValue;
        this.standardDeviation = standardDeviation;
    }

    public abstract double sample();
}
