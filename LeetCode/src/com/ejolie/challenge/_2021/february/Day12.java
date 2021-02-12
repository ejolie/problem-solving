package com.ejolie.challenge._2021.february;

import static org.junit.Assert.assertEquals;

/**
 * Day12. Number of Steps to Reduce a Number to Zero
 */
public class Day12 {
    public static void main(String[] args) {
        assertEquals(6, numberOfSteps(14));
        assertEquals(4, numberOfSteps(8));
        assertEquals(12, numberOfSteps(123));
    }

    public static int numberOfSteps(int num) {
        int steps = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num--;
            }
            steps++;
        }
        return steps;
    }
}
