package src.problems;
/*
 * 9. Palindrome Number
 * Easy
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class Q9 {
    public static void main(String[] args) {
        int x = -121;
        System.out.println(isPalindrome(x));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        Deque<Integer> q = new ArrayDeque<>();
        while (x > 0) {
            q.add(x % 10);
            x /= 10;
        }
        while (q.size() > 1) {
            int first = q.pollFirst();
            int last = q.pollLast();
            if (first != last) {
                return false;
            }
        }
        return true;
    }

}
