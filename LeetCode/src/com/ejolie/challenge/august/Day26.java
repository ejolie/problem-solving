package com.ejolie.challenge.august;

import java.util.LinkedList;
import java.util.List;

/**
 * Day26. Fizz Buzz
 */
public class Day26 {
    public static void main(String[] args) {
        int n = 15;
        List<String> result = fizzBuzz(n);
        System.out.println(result.toString());
    }

    public static List<String> fizzBuzz(int n) {
        List<String> answer = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) answer.add("FizzBuzz");
            else if (i % 3 == 0) answer.add("Fizz");
            else if (i % 5 == 0) answer.add("Buzz");
            else answer.add(String.valueOf(i));
        }
        return answer;
    }
}
