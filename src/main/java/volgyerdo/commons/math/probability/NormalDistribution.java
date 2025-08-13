/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volgyerdo.commons.math.probability;

/**
 *
 * @author Volgyerdo Nonprofit Kft.
 */
public class NormalDistribution extends Distribution{

    public NormalDistribution(double meanValue, double standardDeviation) {
        super(meanValue, standardDeviation);
    }
    
    @Override
    public double sample() {
        return meanValue + RANDOM.nextGaussian() * standardDeviation;
    }
    
}
