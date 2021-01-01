package com.ejolie.challenge._2020.august;

/**
 * Day11. H-Index
 */
public class Day11 {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(hIndex(citations));
    }

    public static int hIndex(int[] citations) {
        int N = citations.length;
        int[] buckets = new int[N + 1];
        for (int c : citations) {
            if (c >= N) {
                buckets[N]++;
            } else {
                buckets[c]++;
            }
        }

        int count = 0;
        for (int i = N; i >= 0; i--) {
            count += buckets[i];
            if (count >= i) {
                return i;
            }
        }
        return 0;
    }
}
