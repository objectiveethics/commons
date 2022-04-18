/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volgyerdo.commons.math.probability;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Volgyerdo Nonprofit Kft.
 */
public class NormalDistributionTest {
    
    private static final double MEAN = 100;
    private static final double DEVIATION = 50;
    private static final double MAX_ERROR = 1;
    
    public NormalDistributionTest() {
    }

    @Test
    public void testSample() {
        final int COUNT = 10000;
        NormalDistribution distribution = new NormalDistribution(100, 50);
        double[] samples = new double[COUNT];
        for(int i = 0; i < COUNT; i++){
            samples[i] = distribution.sample();
        }
        double mean = 0;
        for(int i = 0; i < COUNT; i++){
            mean += samples[i];
        }
        mean /= COUNT;
        double deviation = 0;
        for(int i = 0; i < COUNT; i++){
            deviation += (mean - samples[i]) * (mean - samples[i]);
        }
        deviation = Math.sqrt(deviation / COUNT);
        assertEquals("Normal distribution mean", mean, MEAN, MAX_ERROR);
        assertEquals("Normal distribution standard deviation", deviation, DEVIATION, MAX_ERROR);
    }
    
}
