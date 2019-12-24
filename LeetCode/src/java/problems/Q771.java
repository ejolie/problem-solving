package src.java.problems;

/*
 * 771. Jewels and Stones (Easy)
 */

public class Q771 {
    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";
        System.out.println(numJewelsInStones(J, S));
    }

    // 1. Two for loop
    public static int numJewelsInStones(String J, String S) {
        int cnt = 0;
        for (char jewel : J.toCharArray()) {
            for (char stone : S.toCharArray()) {
                if (jewel == stone) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    // 2. For loop & String.indexOf()
    public static int numJewelsInStones2(String J, String S) {
        int cnt = 0;
        for (char stone : S.toCharArray()) {
            if (J.indexOf(stone) > -1) {
                cnt++;
            }
        }
        return cnt;
    }
}