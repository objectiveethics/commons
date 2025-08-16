package volgyerdo.commons.math.fast;

import org.junit.Test;

public class LogComparisonBenchmark {
    private static final int N = 10_000_000;
    private static final int MIN = 1;
    private static final int MAX = 999;

    @Test
    public void benchmarkLogImplementations() {
        long t0, t1;
        double sum;

        // Math.log
        t0 = System.nanoTime();
        sum = 0;
        for (int i = 0, v = MIN; i < N; i++, v = (v < MAX ? v + 1 : MIN)) {
            sum += Math.log(v);
        }
        t1 = System.nanoTime();
        System.out.println("Math.log:        " + (t1 - t0) / 1_000_000 + " ms, sum=" + sum);

        // StrictMath.log
        t0 = System.nanoTime();
        sum = 0;
        for (int i = 0, v = MIN; i < N; i++, v = (v < MAX ? v + 1 : MIN)) {
            sum += StrictMath.log(v);
        }
        t1 = System.nanoTime();
        System.out.println("StrictMath.log:   " + (t1 - t0) / 1_000_000 + " ms, sum=" + sum);

        // FastMath.log
        t0 = System.nanoTime();
        sum = 0;
        for (int i = 0, v = MIN; i < N; i++, v = (v < MAX ? v + 1 : MIN)) {
            sum += FastMath.log(v);
        }
        t1 = System.nanoTime();
        System.out.println("FastMath.log:     " + (t1 - t0) / 1_000_000 + " ms, sum=" + sum);

        // FastLog.log
        t0 = System.nanoTime();
        sum = 0;
        for (int i = 0, v = MIN; i < N; i++, v = (v < MAX ? v + 1 : MIN)) {
            sum += FastLog.log(v);
        }
        t1 = System.nanoTime();
        System.out.println("FastLog.log:      " + (t1 - t0) / 1_000_000 + " ms, sum=" + sum);
    }
}
