package com.ejolie.challenge._2020.july;

/**
 * Day5. Hamming Distance
 */
public class Day5 {
    public static void main(String[] args) {
        int x = 1;
        int y = 4;
        System.out.println(hammingDistance(x, y));
    }

    public static int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            cnt += (xor >> i) & 1;
        }
        return cnt;
    }

    public static int hammingDistance2(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
