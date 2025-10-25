/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectiveethics.commons.primitive;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Volgyerdo Nonprofit Kft.
 */
public class ArrayUtilsTest {

    public ArrayUtilsTest() {
    }

    @Test
    public void testSum() {
    }

    @Test
    public void testProduct() {
    }

    @Test
    public void testAdd_byteArr_byte() {
    }

    @Test
    public void testAdd_shortArr_short() {
    }

    @Test
    public void testAdd_floatArr_float() {
    }

    @Test
    public void testMultiply_byteArr_byte() {
    }

    @Test
    public void testMultiply_shortArr_short() {
    }

    @Test
    public void testMultiply_floatArr_float() {
    }

    @Test
    public void testDevide_byteArr_byte() {
    }

    @Test
    public void testDevide_shortArr_short() {
    }

    @Test
    public void testDevide_floatArr_float() {
    }

    @Test
    public void testReverse_byteArr() {
    }

    @Test
    public void testReverse_shortArr() {
    }

    @Test
    public void testReverse_intArr() {
    }

    @Test
    public void testReverse_floatArr() {
    }

    @Test
    public void testRandomize_3args_1() {
    }

    @Test
    public void testRandomize_3args_2() {
    }

    @Test
    public void testRandomize_3args_3() {
    }

    @Test
    public void testProcess_byteArr_ByteArrayOperator() {
    }

    @Test
    public void testProcess_shortArr_ShortArrayOperator() {
    }

    @Test
    public void testProcess_floatArr_FloatArrayOperator() {
    }

    @Test
    public void testToBooleanArray() {
    }

    @Test
    public void testToByteArray_shortArr() {
    }

    @Test
    public void testToByteArray_intArr() {
    }

    @Test
    public void testToByteArray_longArr() {
    }

    @Test
    public void testToByteArray_floatArr() {
    }

    @Test
    public void testToByteArray_doubleArr() {
    }

    @Test
    public void testToByteArray_booleanArr() {
    }

    @Test
    public void testToByteArray_charArr() {
    }

    @Test
    public void testToGZIP() {
    }

    @Test
    public void testToByteArray_Object() {
    }

    @Test
    public void testToGZIPByteArray() {
    }

    @Test
    public void testByteBooleanConversion() {
        for (byte x1 = Byte.MIN_VALUE; x1 < Byte.MAX_VALUE; x1++) {
            boolean[] array = ArrayUtils.toBoolArray(x1);
            System.out.println("BYTE " + x1 + " > " + Arrays.toString(array));
            byte x2 = ArrayUtils.toByte(array);
            assertEquals("Byte <-> Boolean array (" + x1 + ")", x1, x2);
        }
    }

    @Test
    public void testShortBooleanConversion() {
        short step = Short.MAX_VALUE / 100;
        for (short x1 = Byte.MIN_VALUE; x1 <= Byte.MAX_VALUE - step; x1+= step) {
            boolean[] array = ArrayUtils.toBoolArray(x1);
            System.out.println("SHORT " + x1 + " > " + Arrays.toString(array));
            short x2 = ArrayUtils.toShort(array);
            assertEquals("Short <-> Boolean array (" + x1 + ")", x1, x2);
        }
    }

    @Test
    public void testIntBooleanConversion() {
        int step = Integer.MAX_VALUE / 100;
        for (int x1 = Integer.MIN_VALUE; x1 <= Integer.MAX_VALUE - step; x1+= step) {
            boolean[] array = ArrayUtils.toBoolArray(x1);
            System.out.println("INT " + x1 + " > " + Arrays.toString(array));
            int x2 = ArrayUtils.toInt(array);
            assertEquals("Integer <-> Boolean array (" + x1 + ")", x1, x2);
        }
    }

    @Test
    public void testLongBooleanConversion() {
        long step = Long.MAX_VALUE / 100;
        for (long x1 = Long.MIN_VALUE; x1 <= Long.MAX_VALUE - step; x1 += step) {
            boolean[] array = ArrayUtils.toBoolArray(x1);
            System.out.println("LONG " + x1 + " > " + Arrays.toString(array));
            long x2 = ArrayUtils.toLong(array);
            assertEquals("Long <-> Boolean array (" + x1 + ")", x1, x2);
        }
    }

    @Test
    public void testFloatBooleanConversion() {
        float step = Float.MAX_VALUE / 100;
        for (float x1 = -Float.MAX_VALUE; x1 <= Float.MAX_VALUE - step; x1+= step) {
            boolean[] array = ArrayUtils.toBoolArray(x1);
            System.out.println("FLOAT " + x1 + " > " + Arrays.toString(array));
            float x2 = ArrayUtils.toFloat(array);
            assertEquals("Float <-> Boolean array (" + x1 + ")", x1, x2, 0.0001);
        }
    }

    @Test
    public void testDoubleBooleanConversion() {
        double step = Double.MAX_VALUE / 100;
        for (double x1 = -Double.MAX_VALUE; x1 <= Double.MAX_VALUE - step; x1+= step) {
            boolean[] array = ArrayUtils.toBoolArray(x1);
            System.out.println("DOUBLE " + x1 + " > " + Arrays.toString(array));
            double x2 = ArrayUtils.toDouble(array);
            assertEquals("Double <-> Boolean array (" + x1 + ")", x1, x2, 0.00000001);
        }
    }

}
