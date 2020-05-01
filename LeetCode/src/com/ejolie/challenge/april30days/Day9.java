package com.ejolie.challenge.april30days;

/**
 * Day9. Backspace String Compare
 */
public class Day9 {
    public static void main(String[] args) {
        String S = "a##c";
        String T = "#a#c";
        System.out.println(backspaceCompare(S, T));
    }

    public static boolean backspaceCompare(String S, String T) {
        int sCnt = 0, tCnt = 0;
        StringBuilder sChars = new StringBuilder();
        StringBuilder tChars = new StringBuilder();

        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) != '#') {
                if (sCnt == 0) sChars.append(S.charAt(i));
                else sCnt--;
            } else {
                sCnt++;
            }
        }

        for (int j = T.length() - 1; j >= 0; j--) {
            if (T.charAt(j) != '#') {
                if (tCnt == 0) tChars.append(T.charAt(j));
                else tCnt--;
            } else {
                tCnt++;
            }
        }

        return sChars.toString().equals(tChars.toString());
    }
}
