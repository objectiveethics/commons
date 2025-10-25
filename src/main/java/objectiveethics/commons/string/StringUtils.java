/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectiveethics.commons.string;

import java.util.Arrays;

/**
 *
 * @author Volgyerdo Nonprofit Kft.
 */
public class StringUtils {

    private StringUtils() {
    }

    public static String constantString(int len, char c) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static String randomString(int len, String charSet) {
        StringBuilder sb = new StringBuilder(len);
        if (charSet == null || charSet.isEmpty()) {
            return sb.toString();
        }
        if (charSet.length() == 1) {
            for (int i = 0; i < len; i++) {
                char c = charSet.charAt(0);
                sb.append(c);
            }
            return sb.toString();
        }
        for (int i = 0; i < len; i++) {
            sb.append(charSet.charAt((int) (Math.random() * charSet.length())));
        }
        return sb.toString();
    }

    public static int levenshteinDistance(String x, String y) {
        int[][] dp = new int[x.length() + 1][y.length() + 1];

        for (int i = 0; i <= x.length(); i++) {
            for (int j = 0; j <= y.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = min(dp[i - 1][j - 1]
                            + costOfSubstitution(x.charAt(i - 1), y.charAt(j - 1)),
                            dp[i - 1][j] + 1,
                            dp[i][j - 1] + 1);
                }
            }
        }

        return dp[x.length()][y.length()];
    }

    private static int min(int... numbers) {
        return Arrays.stream(numbers)
                .min().orElse(Integer.MAX_VALUE);
    }

    private static int costOfSubstitution(char a, char b) {
        return a == b ? 0 : 1;
    }

    public static String maximizeString(String s, int max, boolean points) {
        if (s == null) {
            return null;
        }
        if (points) {
            if (s.length() > max - 3) {
                return s.substring(0, max - 3) + "...";
            }
        } else if (s.length() > max) {
            return s.substring(0, max);
        }
        return s;
    }
}
