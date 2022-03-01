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
public class UniformDistribution extends Distribution{

    private static final double ROOT3 = Math.sqrt(3);
    private final double minimum, width;
    
    public UniformDistribution(double meanValue, double standardDeviation) {
        super(meanValue, standardDeviation);
        minimum = meanValue - ROOT3 *  standardDeviation;
        width = meanValue + ROOT3 *  standardDeviation;
    }

    @Override
    public double sample() {
        return minimum + RANDOM.nextDouble() * width;
    }
    
}
