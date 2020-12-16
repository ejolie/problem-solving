package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 와일드카드 (난이도: 중)
 */
public class aoj_wildcard {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n = 0;
    static int[][] memo;

    public static void main(String[] args) throws IOException {
        int cases = Integer.parseInt(br.readLine().trim());

        while (cases-- > 0) {
            String pattern = br.readLine().trim();
            n = Integer.parseInt(br.readLine().trim());

            String[] filenames = new String[n];
            for (int i = 0; i < n; i++) {
                filenames[i] = br.readLine().trim();
            }

            memo = new int[101][101];
            for (int[] m : memo) {
                Arrays.fill(m, -1);
            }

            List<String> answer = new LinkedList<>();
            for (String filename : filenames) {
                if (doesMatch_memoized(pattern, filename, 0, 0)) {
                    answer.add(filename);
                }
            }

            answer.sort(String::compareTo);
            for (String filename : answer) {
                System.out.println(filename);
            }
        }
    }

    /**
     * 패턴 w이 문자열 s에 대응되는지 여부를 반환한다.
     * <p>
     * - while문이 종료하는 경우
     * case 1. w[pos]와 s[pos]가 대응되지 않음
     * case 2. w 끝에 도달함: 패턴에 *이 하나도 없는 경우 -> 패턴과 문자열의 길이가 정확히 같아야 함
     * case 3. s 끝에 도달함: 남은 패턴이 전부 *인 경우를 제외 하고 대응 실패
     * case 4. w[pos]가 *임: *가 몇 글자에 대응될지 몰라 모든 가능성을 검사
     */
    public static boolean doesMatch_bruteForce(String w, String s) {
        // w[pos]와 s[pos]를 맞춰나간다.
        int pos = 0;
        while (pos < w.length() && pos < s.length()
                && (w.charAt(pos) == s.charAt(pos) || w.charAt(pos) == '?')) {
            pos++;
        }

        // 더 이상 대응할 수 없으면 왜 while문이 끝났는지 확인한다.
        // case 2. w 끝에 도달해서 끝난 경우: 문자열도 끝났어야 대응됨
        if (pos == w.length()) {
            return pos == s.length();
        }

        // case 4. *를 만나서 끝난 경우: *에 몇 글자가 대응되는지 재귀 호출하면서 확인한다. (skip: *에 대응되는 글자 수)
        if (w.charAt(pos) == '*') {
            for (int skip = 0; pos + skip <= s.length(); skip++) {
                if (doesMatch_bruteForce(w.substring(pos + 1), s.substring(pos + skip))) {
                    return true;
                }
            }
        }

        // 이 외의 경우에는 모두 대응되지 않는다.
        return false;
    }

    /**
     * 패턴 w[wpos..]가 문자열 s[spos..]에 대응되는지 여부를 반환한다.
     */
    public static boolean doesMatch_memoized(String w, String s, int wpos, int spos) {
        // 메모이제이션
        if (memo[wpos][spos] != -1) {
            return memo[wpos][spos] == 1;
        }

        // w[wpos]와 s[spos]를 맞춰나간다.
        if (wpos < w.length() && spos < s.length()
                && (w.charAt(wpos) == s.charAt(spos) || w.charAt(wpos) == '?')) {
            memo[wpos][spos] = doesMatch_memoized(w, s, wpos + 1, spos + 1) ? 1 : 0;
            return memo[wpos][spos] == 1;
        }

        // case 2. w 끝에 도달해서 끝난 경우: 문자열도 끝났어야 대응됨
        if (wpos == w.length()) {
            memo[wpos][spos] = spos == s.length() ? 1 : 0;
            return memo[wpos][spos] == 1;
        }

        // case 4. *를 만나서 끝난 경우: *에 몇 글자가 대응되는지 재귀 호출하면서 확인한다.
        if (w.charAt(wpos) == '*') {
            if (doesMatch_memoized(w, s, wpos + 1, spos)
                    || (spos < s.length() && doesMatch_memoized(w, s, wpos, spos + 1))) {
                memo[wpos][spos] = 1;
                return true;
            }
        }

        // 이 외의 경우에는 모두 대응되지 않는다.
        memo[wpos][spos] = 0;
        return false;
    }
}
