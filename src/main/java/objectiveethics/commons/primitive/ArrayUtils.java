/*
 * Copyright 2021 Volgyerdo Nonprofit Kft.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package objectiveethics.commons.primitive;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.zip.GZIPOutputStream;

/**
 *
 * @author Volgyerdo Nonprofit Kft.
 */
public class ArrayUtils {

    private ArrayUtils() {
    }

    public static int sum(int array[]) {
        int product = 1;
        for (int i : array) {
            product += i;
        }
        return product;
    }

    public static int product(int array[]) {
        int product = 1;
        for (int i : array) {
            product *= i;
        }
        return product;
    }

    public static void add(byte array[], byte x) {
        for (int i = 0; i < array.length; i++) {
            array[i] += x;
        }
    }

    public static void add(short array[], short x) {
        for (int i = 0; i < array.length; i++) {
            array[i] += x;
        }
    }

    public static void add(float array[], float x) {
        for (int i = 0; i < array.length; i++) {
            array[i] += x;
        }
    }

    public static void multiply(byte array[], byte x) {
        for (int i = 0; i < array.length; i++) {
            array[i] *= x;
        }
    }

    public static void multiply(short array[], short x) {
        for (int i = 0; i < array.length; i++) {
            array[i] *= x;
        }
    }

    public static void multiply(float array[], float x) {
        for (int i = 0; i < array.length; i++) {
            array[i] *= x;
        }
    }

    public static void devide(byte array[], byte x) {
        for (int i = 0; i < array.length; i++) {
            array[i] /= x;
        }
    }

    public static void devide(short array[], short x) {
        for (int i = 0; i < array.length; i++) {
            array[i] /= x;
        }
    }

    public static void devide(float array[], float x) {
        for (int i = 0; i < array.length; i++) {
            array[i] /= x;
        }
    }

    public static byte[] reverse(byte a[]) {
        byte[] b = new byte[a.length];
        int n = a.length - 1;
        for (int i = 0; i < a.length; i++) {
            b[n - i] = a[i];

        }
        return b;
    }

    public static short[] reverse(short a[]) {
        short[] b = new short[a.length];
        int n = a.length - 1;
        for (int i = 0; i < a.length; i++) {
            b[n - i] = a[i];

        }
        return b;
    }

    public static int[] reverse(int a[]) {
        int[] b = new int[a.length];
        int n = a.length - 1;
        for (int i = 0; i < a.length; i++) {
            b[n - i] = a[i];
        }
        return b;
    }

    public static float[] reverse(float a[]) {
        float[] b = new float[a.length];
        int n = a.length - 1;
        for (int i = 0; i < a.length; i++) {
            b[n - i] = a[i];
        }
        return b;
    }

    public static void randomize(byte[] a, byte min, byte max) {
        double delta = max - min;
        for (int i = 0; i < a.length; i++) {
            a[i] = (byte) (Math.random() * delta + min);
        }
    }

    public static void randomize(short[] a, short min, short max) {
        double delta = max - min;
        for (int i = 0; i < a.length; i++) {
            a[i] = (short) (Math.random() * delta + min);
        }
    }

    public static void randomize(float[] a, float min, float max) {
        float delta = max - min;
        for (int i = 0; i < a.length; i++) {
            a[i] = (float) (Math.random() * delta + min);
        }
    }

    public static void process(byte[] a, ByteArrayOperator operator) {
        for (int i = 0; i < a.length; i++) {
            a[i] = operator.applyAsByte(a[i], i);
        }
    }

    public static void process(short[] a, ShortArrayOperator operator) {
        for (int i = 0; i < a.length; i++) {
            a[i] = operator.applyAsShort(a[i], i);
        }
    }

    public static void process(float[] a, FloatArrayOperator operator) {
        for (int i = 0; i < a.length; i++) {
            a[i] = operator.applyAsFloat(a[i], i);
        }
    }

    public static boolean[] toBooleanArray(byte[] array) {
        if (array == null) {
            return null;
        }
        boolean[] booleanArray = new boolean[array.length * 8];
        for (int i = 0; i < array.length; i++) {
            System.arraycopy(toBoolArray(array[i]), 0, booleanArray, i * 8, 8);
        }
        return booleanArray;
    }

    public static byte[] toByteArray(short[] array) {
        if (array == null) {
            return null;
        }
        byte[] byteArray = new byte[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            byteArray[i * 2] = (byte) (array[i] & 0xff);
            byteArray[i * 2 + 1] = (byte) ((array[i] >> 8) & 0xff);
        }
        return byteArray;
    }

    public static byte[] toByteArray(int[] array) {
        if (array == null) {
            return null;
        }
        byte[] byteArray = new byte[array.length * 4];
        for (int i = 0; i < array.length; i++) {
            byteArray[i * 4] = (byte) (array[i] & 0xff);
            byteArray[i * 4 + 1] = (byte) ((array[i] >> 8) & 0xff);
            byteArray[i * 4 + 2] = (byte) ((array[i] >> 16) & 0xff);
            byteArray[i * 4 + 3] = (byte) ((array[i] >> 24) & 0xff);
        }
        return byteArray;
    }

    public static byte[] toByteArray(long[] array) {
        if (array == null) {
            return null;
        }
        byte[] byteArray = new byte[array.length * 8];
        for (int i = 0; i < array.length; i++) {
            byteArray[i * 8] = (byte) (array[i] & 0xff);
            byteArray[i * 8 + 1] = (byte) ((array[i] >> 8) & 0xff);
            byteArray[i * 8 + 2] = (byte) ((array[i] >> 16) & 0xff);
            byteArray[i * 8 + 3] = (byte) ((array[i] >> 24) & 0xff);
            byteArray[i * 8 + 4] = (byte) ((array[i] >> 32) & 0xff);
            byteArray[i * 8 + 5] = (byte) ((array[i] >> 40) & 0xff);
            byteArray[i * 8 + 6] = (byte) ((array[i] >> 48) & 0xff);
            byteArray[i * 8 + 7] = (byte) ((array[i] >> 56) & 0xff);
        }
        return byteArray;
    }

    public static byte[] toByteArray(float[] array) {
        if (array == null) {
            return null;
        }
        byte[] byteArray = new byte[array.length * 4];
        for (int i = 0; i < array.length; i++) {
            int intBits = Float.floatToIntBits(array[i]);
            byteArray[i * 4] = (byte) (intBits & 0xff);
            byteArray[i * 4 + 1] = (byte) ((intBits >> 8) & 0xff);
            byteArray[i * 4 + 2] = (byte) ((intBits >> 16) & 0xff);
            byteArray[i * 4 + 3] = (byte) ((intBits >> 24) & 0xff);
        }
        return byteArray;
    }

    public static byte[] toByteArray(double[] array) {
        if (array == null) {
            return null;
        }
        byte[] byteArray = new byte[array.length * 8];
        for (int i = 0; i < array.length; i++) {
            long longBits = Double.doubleToLongBits(array[i]);
            byteArray[i * 8] = (byte) (longBits & 0xff);
            byteArray[i * 8 + 1] = (byte) ((longBits >> 8) & 0xff);
            byteArray[i * 8 + 2] = (byte) ((longBits >> 16) & 0xff);
            byteArray[i * 8 + 3] = (byte) ((longBits >> 24) & 0xff);
            byteArray[i * 8 + 4] = (byte) ((longBits >> 32) & 0xff);
            byteArray[i * 8 + 5] = (byte) ((longBits >> 40) & 0xff);
            byteArray[i * 8 + 6] = (byte) ((longBits >> 48) & 0xff);
            byteArray[i * 8 + 7] = (byte) ((longBits >> 56) & 0xff);
        }
        return byteArray;
    }

    public static byte[] toByteArray(boolean[] array) {
        if (array == null) {
            return null;
        }
        byte[] byteArray = new byte[(int) Math.ceil(array.length / 8.)];
        for (int i = 0; i < byteArray.length; i++) {
            for (int j = 0; j < 8; j++) {
                if (array.length < i * 8 + j) {
                    byteArray[i] += array[i * 8 + j] ? 1 << j : 0;
                }
            }
        }
        return byteArray;
    }

    public static byte[] toByteArray(char[] array) {
        if (array == null) {
            return null;
        }
        byte[] byteArray = new byte[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            byteArray[i * 2] = (byte) (array[i] & 0xff);
            byteArray[i * 2 + 1] = (byte) ((array[i] >> 8) & 0xff);
        }
        return byteArray;
    }

    public static byte[] toGZIP(byte[] values) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try ( GZIPOutputStream zipStream = new GZIPOutputStream(bos);) {
            zipStream.write(values);
        } catch (IOException ex) {
            //
        }
        return bos.toByteArray();
    }

    public static byte[] toByteArray(Object object) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try ( ObjectOutputStream objectStream = new ObjectOutputStream(bos)) {
            objectStream.writeObject(object);
        } catch (IOException ex) {
            //
        }
        return bos.toByteArray();
    }

    public static byte[] toGZIPByteArray(Object object) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try ( GZIPOutputStream zipStream = new GZIPOutputStream(bos);  ObjectOutputStream objectStream = new ObjectOutputStream(zipStream)) {
            objectStream.writeObject(object);
        } catch (IOException ex) {
            //
        }
        return bos.toByteArray();
    }

    public static byte toByte(boolean[] source) {
        if (source.length != 8) {
            throw new IllegalArgumentException();
        }
        byte b = 0;
        for (int i = 0; i < 8; i++) {
            if (source[i]) {
                b |= 1 << i;
            }
        }
        return b;
    }

    public static short toShort(boolean[] source) {
        if (source.length != 16) {
            throw new IllegalArgumentException();
        }
        short b = 0;
        for (int i = 0; i < 16; i++) {
            if (source[i]) {
                b |= 1 << i;
            }
        }
        return b;
    }

    public static int toInt(boolean[] source) {
        if (source.length != 32) {
            throw new IllegalArgumentException();
        }
        int b = 0;
        for (int i = 0; i < 32; i++) {
            if (source[i]) {
                b |= 1 << i;
            }
        }
        return b;
    }

    public static long toLong(boolean[] source) {
        if (source.length != 64) {
            throw new IllegalArgumentException();
        }
        long b = 0;
        for (int i = 0; i < 64; i++) {
            if (source[i]) {
                b |= 1L << i;
            }
        }
        return b;
    }

    public static float toFloat(boolean[] source) {
        if (source.length != 32) {
            throw new IllegalArgumentException();
        }
        int b = 0;
        for (int i = 0; i < 32; i++) {
            if (source[i]) {
                b |= 1 << i;
            }
        }
        return Float.intBitsToFloat(b);
    }

    public static double toDouble(boolean[] source) {
        if (source.length != 64) {
            throw new IllegalArgumentException();
        }
        long b = 0;
        for (int i = 0; i < 64; i++) {
            if (source[i]) {
                b |= 1L << i;
            }
        }
        return Double.longBitsToDouble(b);
    }

    public static boolean[] toBoolArray(byte b) {
        boolean[] array = new boolean[8];
        for (int i = 0; i < 8; i++) {
            array[i] = (b & (1 << i)) != 0;
        }
        return array;
    }

    public static boolean[] toBoolArray(short b) {
        boolean[] array = new boolean[16];
        for (int i = 0; i < 16; i++) {
            array[i] = (b & (1 << i)) != 0;
        }
        return array;
    }

    public static boolean[] toBoolArray(int b) {
        boolean[] array = new boolean[32];
        for (int i = 0; i < 32; i++) {
            array[i] = (b & (1 << i)) != 0;
        }
        return array;
    }

    public static boolean[] toBoolArray(long b) {
        boolean[] array = new boolean[64];
        for (int i = 0; i < 64; i++) {
            array[i] = (b & (1L << i)) != 0;
        }
        return array;
    }

    public static boolean[] toBoolArray(float b) {
        boolean[] array = new boolean[32];
        int n = Float.floatToRawIntBits(b);
        for (int i = 0; i < 32; i++) {
            array[i] = (n & (1 << i)) != 0;
        }
        return array;
    }

    public static boolean[] toBoolArray(double b) {
        boolean[] array = new boolean[64];
        long n = Double.doubleToRawLongBits(b);
        for (int i = 0; i < 64; i++) {
            array[i] = (n & (1L << i)) != 0;
        }
        return array;
    }
}
