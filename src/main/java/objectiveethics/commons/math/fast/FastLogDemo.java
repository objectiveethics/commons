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
package objectiveethics.commons.math.fast;

/**
 * Demo class showing FastLog usage and performance comparison.
 * 
 * @author Völgyérdo Nonprofit Kft.
 */
public class FastLogDemo {
    
    public static void main(String[] args) {
        System.out.println("FastLog Demo");
        System.out.println("============");
        
        // Basic functionality demo
        System.out.println("\nBasic log2 calculations:");
        double[] testValues = {1.0, 2.0, 4.0, 8.0, 16.0, 32.0, 64.0, 128.0, 256.0, 512.0, 1024.0};
        
        for (double value : testValues) {
            double result = FastLog.log2(value);
            System.out.printf("log2(%.0f) = %.6f\n", value, result);
        }
        
        // Integer vs double comparison
        System.out.println("\nInteger vs Double log2 comparison:");
        for (int i = 1; i <= 20; i++) {
            double intResult = FastLog.log2(i);
            double doubleResult = FastLog.log2((double) i);
            System.out.printf("Value: %2d, int: %.6f, double: %.6f, diff: %.9f\n", 
                            i, intResult, doubleResult, Math.abs(intResult - doubleResult));
        }
        
        // Lookup table info
        System.out.println("\nLookup table information:");
        System.out.println("Lookup table size: " + FastLog.getLookupTableSize());
        
        // Trigger lookup table initialization
        FastLog.log2(10);
        
        // Performance comparison
        System.out.println("\nPerformance comparison:");
        performanceTest();
        
        // Edge cases
        System.out.println("\nEdge cases:");
        System.out.println("log2(0) = " + FastLog.log2(0));
        System.out.println("log2(-1) = " + FastLog.log2(-1));
        System.out.println("log2(0.0) = " + FastLog.log2(0.0));
        System.out.println("log2(-1.0) = " + FastLog.log2(-1.0));
        System.out.println("log2(Double.POSITIVE_INFINITY) = " + FastLog.log2(Double.POSITIVE_INFINITY));
    }
    
    private static void performanceTest() {
        final int ITERATIONS = 1_000_000;
        final int WARMUP_ITERATIONS = 100_000;
        
        // Warm up
        for (int i = 0; i < WARMUP_ITERATIONS; i++) {
            FastLog.log2(i % 999 + 1);
            FastLog.log2((double)(i % 999 + 1));
        }
        
        // Test lookup table performance (int values)
        long startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            FastLog.log2(i % 999 + 1); // Keep within lookup table range
        }
        long lookupTime = System.nanoTime() - startTime;
        
        // Test double calculation performance
        startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            FastLog.log2((double)(i % 999 + 1));
        }
        long doubleTime = System.nanoTime() - startTime;
        
        // Test outside lookup table range
        startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            FastLog.log2(i % 10000 + 1000); // Outside lookup table range
        }
        long outsideTime = System.nanoTime() - startTime;
        
        System.out.printf("Lookup table (int, within range): %,d ns total, %.2f ns/op\n", 
                         lookupTime, (double)lookupTime / ITERATIONS);
        System.out.printf("Double calculation: %,d ns total, %.2f ns/op\n", 
                         doubleTime, (double)doubleTime / ITERATIONS);
        System.out.printf("Outside lookup range: %,d ns total, %.2f ns/op\n", 
                         outsideTime, (double)outsideTime / ITERATIONS);
        
        double speedupVsDouble = (double)doubleTime / lookupTime;
        double speedupVsOutside = (double)outsideTime / lookupTime;
        
        System.out.printf("Speedup vs double calculation: %.2fx\n", speedupVsDouble);
        System.out.printf("Speedup vs outside range: %.2fx\n", speedupVsOutside);
    }
}
