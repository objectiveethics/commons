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
package volgyerdo.commons.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 *
 * @author Volgyerdo Nonprofit Kft.
 */
public class CollectionUtils {

    public static Object getLastElement(List list) {
        if (list == null || list.isEmpty()) {
            throw new NoSuchElementException();
        }
        return list.get(list.size() - 1);
    }

    public static List<List> breakApart(List values, int size, boolean withStub) {
        List<List> ret = new ArrayList<>((values.size() + size - 1) / size);
        if (withStub) {
            for (int start = 0; start < values.size(); start += size) {
                List subList = values.subList(start, Math.min(values.size(), start + size));
                ret.add(subList);
            }
        } else {
            int maxIndex = (values.size() / size) * size;
            for (int start = 0; start < maxIndex; start += size) {
                List subList = values.subList(start, start + size);
                ret.add(subList);
            }
        }
        return ret;
    }

    public static List<Character> convertStringToCharList(String str) {
        List<Character> chars = new ArrayList<>();
        for (char ch : str.toCharArray()) {
            chars.add(ch);
        }
        return chars;
    }

    public static List<Character> convertCharArrayToList(char[] chars) {
        List<Character> list = new ArrayList<>();
        for (char x : chars) {
            list.add(x);
        }
        return list;
    }

    public static List<Boolean> convertBooleanArrayToList(boolean[] array) {
        List<Boolean> list = new ArrayList<>(array.length);
        for (boolean x : array) {
            list.add(x);
        }
        return list;
    }

    public static List<Byte> convertByteArrayToList(byte[] array) {
        List<Byte> list = new ArrayList<>(array.length);
        for (byte x : array) {
            list.add(x);
        }
        return list;
    }

    public static List<Short> convertShortArrayToList(short[] chars) {
        List<Short> list = new ArrayList<>();
        for (short x : chars) {
            list.add(x);
        }
        return list;
    }

    public static List<Integer> convertIntArrayToList(int[] chars) {
        List<Integer> list = new ArrayList<>();
        for (int x : chars) {
            list.add(x);
        }
        return list;
    }

    public static List<Long> convertLongArrayToList(long[] chars) {
        List<Long> list = new ArrayList<>();
        for (long x : chars) {
            list.add(x);
        }
        return list;
    }

    public static List<Float> convertFloatArrayToList(float[] chars) {
        List<Float> list = new ArrayList<>();
        for (float x : chars) {
            list.add(x);
        }
        return list;
    }

    public static List<Double> convertDoubleArrayToList(double[] chars) {
        List<Double> list = new ArrayList<>();
        for (double x : chars) {
            list.add(x);
        }
        return list;
    }

    private CollectionUtils() {
    }

}
