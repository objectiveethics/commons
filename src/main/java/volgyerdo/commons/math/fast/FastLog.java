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

/**
 * Fast logarithm utility class providing optimized log2 implementations.
 * 
 * @author Völgyérdo Nonprofit Kft.
 */
public class FastLog {

    /** Natural logarithm of 2 */
    private static final double LOG_2 = Math.log(2.0);

    /** Reciprocal of natural logarithm of 2 for fast log2 calculation */
    private static final double INV_LOG_2 = 1.0 / LOG_2;

    /** Lookup table size for integer log/log2 */
    private static final int LOOKUP_TABLE_SIZE = 1000;


    /** Lookup table for log2 values */
    private static final double[] log2Lookup;
    /** Lookup table for natural log values */
    private static final double[] logLookup;

    static {
        log2Lookup = new double[LOOKUP_TABLE_SIZE];
        logLookup = new double[LOOKUP_TABLE_SIZE];
        log2Lookup[0] = Double.NEGATIVE_INFINITY;
        logLookup[0] = Double.NEGATIVE_INFINITY;
        double log;
        for (int i = 1; i < LOOKUP_TABLE_SIZE; i++) {
            log = Math.log(i);
            log2Lookup[i] = log * INV_LOG_2;
            logLookup[i] = log;
        }
    }

    /**
     * Private constructor to prevent instantiation.
     */
    private FastLog() {
        // Utility class
    }
    

    /**
     * Calculates the natural logarithm of a double value.
     * @param value the value to calculate log for
     * @return log(value)
     */
    public static double log(double value) {
        return FastMath.log(value);
    }

    /**
     * Calculates the base-2 logarithm of a double value.
     * @param value the value to calculate log2 for
     * @return log2(value)
     */
    public static double log2(double value) {
        return Math.log(value) * INV_LOG_2;
    }
    

    /**
     * Calculates the natural logarithm of an int value using a lookup table.
     * For values outside the lookup table range, falls back to double calculation.
     * @param value the value to calculate log for
     * @return log(value)
     */
    public static double log(int value) {
        if (value <= 0) {
            if (value == 0) {
                return Double.NEGATIVE_INFINITY;
            }
            return Double.NaN;
        }
        if (value < LOOKUP_TABLE_SIZE) {
            return logLookup[value];
        }
        return log((double) value);
    }

    /**
     * Calculates the base-2 logarithm of an integer value using a lookup table.
     * For values outside the lookup table range, falls back to double calculation.
     * @param value the value to calculate log2 for
     * @return log2(value)
     */
    public static double log2(int value) {
        if (value <= 0) {
            if (value == 0) {
                return Double.NEGATIVE_INFINITY;
            }
            return Double.NaN;
        }
        if (value < LOOKUP_TABLE_SIZE) {
            return log2Lookup[value];
        }
        return log2((double) value);
    }

    /**
     * Calculates the natural logarithm of a long value using a lookup table for small values.
     * @param value the value to calculate log for
     * @return log(value)
     */
    public static double log(long value) {
        if (value <= 0L) {
            if (value == 0L) {
                return Double.NEGATIVE_INFINITY;
            }
            return Double.NaN;
        }
        if (value < LOOKUP_TABLE_SIZE) {
            return logLookup[(int) value];
        }
        return log((double) value);
    }

    /**
     * Calculates the base-2 logarithm of a long value using a lookup table for small values.
     * @param value the value to calculate log2 for
     * @return log2(value)
     */
    public static double log2(long value) {
        if (value <= 0L) {
            if (value == 0L) {
                return Double.NEGATIVE_INFINITY;
            }
            return Double.NaN;
        }
        if (value < LOOKUP_TABLE_SIZE) {
            return log2Lookup[(int) value];
        }
        return log2((double) value);
    }
    

    
    /**
     * Gets the size of the lookup tables.
     * @return the lookup table size
     */
    public static int getLookupTableSize() {
        return LOOKUP_TABLE_SIZE;
    }


}
