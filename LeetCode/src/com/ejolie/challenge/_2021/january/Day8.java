package com.ejolie.challenge._2021.january;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Day8. Check If Two String Arrays are Equivalent
 */
public class Day8 {
    public static void main(String[] args) {
        assertTrue(arrayStringsAreEqual_pointer(new String[]{"ab", "c"}, new String[]{"a", "bc"}));
        assertFalse(arrayStringsAreEqual_pointer(new String[]{"a", "cb"}, new String[]{"ab", "c"}));
        assertTrue(arrayStringsAreEqual_pointer(new String[]{"abc", "d", "defg"}, new String[]{"abcddefg"}));
    }

    public static boolean arrayStringsAreEqual_stringBuilder(String[] word1, String[] word2) {
        StringBuilder str1 = new StringBuilder();
        for (String word : word1) {
            str1.append(word);
        }

        StringBuilder str2 = new StringBuilder();
        for (String word : word2) {
            str2.append(word);
        }

        return str1.toString().equals(str2.toString());
    }

    public static boolean arrayStringsAreEqual_join(String[] word1, String[] word2) {
        return String.join("", word1).equals(String.join("", word2));
    }

    public static boolean arrayStringsAreEqual_pointer(String[] word1, String[] word2) {
        int arrIdx1 = 0, arrIdx2 = 0, idx1 = 0, idx2 = 0;
        while (arrIdx1 < word1.length && arrIdx2 < word2.length) {
            if (word1[arrIdx1].charAt(idx1) != word2[arrIdx2].charAt(idx2)) {
                return false;
            }

            if (idx1 == word1[arrIdx1].length() - 1) {
                idx1 = 0;
                arrIdx1++;
            } else {
                idx1++;
            }

            if (idx2 == word2[arrIdx2].length() - 1) {
                idx2 = 0;
                arrIdx2++;
            } else {
                idx2++;
            }
        }

        return arrIdx1 == word1.length && arrIdx2 == word2.length;
    }
}
