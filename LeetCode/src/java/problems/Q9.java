package src.java.problems;
/*
 * 9. Palindrome Number (Easy)
 */

public class Q9 {
    public static void main(String[] args) {
        int x = 121;
        System.out.println(isPalindrome(x));
    }

    // 1. Without Integer -> String (cf. Q7)
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int original = x;
        int res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res == original;
    }

    // 2. Integer -> String
    public static boolean isPalindrome2(int x) {
        String str = String.valueOf(x);
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
