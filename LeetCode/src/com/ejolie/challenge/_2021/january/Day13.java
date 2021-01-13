package com.ejolie.challenge._2021.january;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Day13. Boats to Save People
 */
public class Day13 {
    public static void main(String[] args) {
        assertEquals(1, numRescueBoats(new int[]{1, 2}, 3));
        assertEquals(3, numRescueBoats(new int[]{3, 2, 2, 1}, 3));
        assertEquals(4, numRescueBoats(new int[]{3, 5, 3, 4}, 5));

        int[] people1 = {2, 49, 10, 7, 11, 41, 47, 2, 22, 6, 13, 12, 33, 18, 10, 26, 2, 6, 50, 10};
        int limit1 = 50;
        assertEquals(11, numRescueBoats(people1, limit1));
    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int l = 0, r = people.length - 1;
        while (l < r) {
            if (people[l] + people[r] <= limit) {
                l++;
            }
            r--;
        }

        return people.length - l;
    }
}
