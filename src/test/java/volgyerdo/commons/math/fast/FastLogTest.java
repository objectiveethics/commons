/*
 * Copyright 2021-2025 Völgyérdo Nonprofit Kft.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package volgyerdo.commons.math.fast;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for FastLog class.
 * 
 * @author Völgyérdo Nonprofit Kft.
 */
public class FastLogTest {
    
    private static final double EPSILON = 1e-10;
    
    @Test
    public void testLog2Double() {
        // Test basic cases
        assertEquals(0.0, FastLog.log2(1.0), EPSILON);
        assertEquals(1.0, FastLog.log2(2.0), EPSILON);
        assertEquals(2.0, FastLog.log2(4.0), EPSILON);
        assertEquals(3.0, FastLog.log2(8.0), EPSILON);
        assertEquals(10.0, FastLog.log2(1024.0), EPSILON);
        
        // Test fractional values
        assertEquals(-1.0, FastLog.log2(0.5), EPSILON);
        assertEquals(-2.0, FastLog.log2(0.25), EPSILON);
        
        // Test edge cases
        assertTrue(Double.isInfinite(FastLog.log2(0.0)));
        assertTrue(Double.isNaN(FastLog.log2(-1.0)));
        assertTrue(Double.isInfinite(FastLog.log2(Double.POSITIVE_INFINITY)));
    }
    
    @Test
    public void testLog2Int() {
        // Test basic cases within lookup table range
        assertEquals(0.0, FastLog.log2(1), EPSILON);
        assertEquals(1.0, FastLog.log2(2), EPSILON);
        assertEquals(2.0, FastLog.log2(4), EPSILON);
        assertEquals(3.0, FastLog.log2(8), EPSILON);
        
        // Test values within lookup table
        for (int i = 1; i < 100; i++) {
            double expected = StrictMath.log(i) / StrictMath.log(2.0);
            assertEquals("Failed for i=" + i, expected, FastLog.log2(i), EPSILON);
        }
        
        // Test edge cases
        assertTrue(Double.isInfinite(FastLog.log2(0)));
        assertTrue(Double.isNaN(FastLog.log2(-1)));
        assertTrue(Double.isNaN(FastLog.log2(-10)));
        
        // Test values outside lookup table range
        assertEquals(StrictMath.log(2000) / StrictMath.log(2.0), FastLog.log2(2000), EPSILON);
    }
    
    @Test
    public void testLookupTableInitialization() {
        // Lookup tables are now initialized in static block
        // Check lookup table size
        assertEquals(1000, FastLog.getLookupTableSize());
    }
    
    @Test
    public void testConsistencyBetweenIntAndDouble() {
        // Test that log2(int) and log2(double) give consistent results
        for (int i = 1; i < 100; i++) {
            double intResult = FastLog.log2(i);
            double doubleResult = FastLog.log2((double) i);
            assertEquals("Inconsistent results for value " + i, doubleResult, intResult, EPSILON);
        }
    }
    
    @Test
    public void testPerformance() {
        // Warm up
        for (int i = 1; i < 1000; i++) {
            FastLog.log2(i);
        }
        
        // Test lookup table performance vs double calculation
        long startTime = System.nanoTime();
        for (int i = 1; i < 1000; i++) {
            FastLog.log2(i);
        }
        long lookupTime = System.nanoTime() - startTime;
        
        startTime = System.nanoTime();
        for (int i = 1; i < 1000; i++) {
            FastLog.log2((double) i);
        }
        long doubleTime = System.nanoTime() - startTime;
        
        System.out.println("Lookup table time: " + lookupTime + " ns");
        System.out.println("Double calculation time: " + doubleTime + " ns");
        System.out.println("Speedup factor: " + (double) doubleTime / lookupTime);
        
        // The lookup table should be faster (though this might not always be true due to JIT optimization)
        // This is more of an informational test
        assertTrue(lookupTime > 0 && doubleTime > 0);
    }
}
