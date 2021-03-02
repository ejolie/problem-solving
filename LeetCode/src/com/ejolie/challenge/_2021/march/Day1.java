package com.ejolie.challenge._2021.march;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Day1. Distribute Candies
 */
public class Day1 {
    public static void main(String[] args) {
        assertEquals(3, distributeCandies(new int[]{1, 1, 2, 2, 3, 3}));
        assertEquals(2, distributeCandies(new int[]{1, 1, 2, 3}));
        assertEquals(1, distributeCandies(new int[]{6, 6, 6, 6}));
    }

    // 33 ms, 41.2 MB
    public static int distributeCandies(int[] candyType) {
        Set<Integer> candySet = new HashSet<>();
        for (int type : candyType) {
            candySet.add(type);
        }

        int maxToEat = candyType.length / 2;
        int candyTypeCount = candySet.size();
        return Math.min(maxToEat, candyTypeCount);
    }

    // 4 ms, 40.1 MB
    public static int distributeCandies_booleanArray(int[] candyType) {
        boolean[] type = new boolean[200001];
        int maxToEat = candyType.length / 2;
        int count = 0;
        for (int candy : candyType) {
            int t = candy + 100000; // 음수 값 처리
            if (!type[t]) {
                if (++count == maxToEat) { // 최대 먹을 수 있는 개수
                    return maxToEat;
                }
                type[t] = true;
            }
        }
        return count; // 캔디 종류
    }

    //7 ms, 40.6 MB
    public static int distributeCandies_bitSet(int[] candyType) {
        BitSet bits = new BitSet(200001);
        int maxToEat = candyType.length / 2;
        int count = 0;
        for (int candy : candyType) {
            int t = candy + 100000;
            if (!bits.get(t)) {
                if (++count == maxToEat) {
                    return maxToEat;
                }
                bits.set(t);
            }
        }
        return count;
    }

    // 42 ms, 41.3 MB
    public int distributeCandies_stream(int[] candyType) {
        int maxToEat = candyType.length / 2;
        int candyTypeCount = (int) Arrays.stream(candyType).distinct().count();
        return Math.min(maxToEat, candyTypeCount);
    }
}
