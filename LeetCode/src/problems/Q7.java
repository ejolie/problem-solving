package src.problems;
/*
 * 7. Reverse Integer
 * Easy
 */

public class Q7 {
    public static void main(String[] args) {
        int x = -123;
        System.out.println(reverse2(x));
    }

    // 1. StringBuilder.reverse()
    public static int reverse(int x) {
        StringBuilder sb = x < 0 ? new StringBuilder(String.valueOf(-x)).append("-")
                : new StringBuilder(String.valueOf(x));
        String reversed = sb.reverse().toString();

        try {
            return Integer.parseInt(reversed);
        } catch (Exception e) {
            return 0;
        }
    }

    // 2. Math Pop & Push
    public static int reverse2(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }

        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) res;
    }
}
