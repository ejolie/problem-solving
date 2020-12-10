package challenge.kakao;

/**
 * 2020 KAKAO BLIND RECRUITMENT - 문자열 압축
 */
public class pg_60057 {
    public static void main(String[] args) {
        // System.out.println(solution2("aabbaccc"));
        // System.out.println(solution2("ababcdcdababcdcd"));
        // System.out.println(solution2("abcabcdede"));
        System.out.println(solution2("abcabcabcabcdededededede"));
        // System.out.println(solution2("xababcdcdababcdcd"));
    }

    public static int solution2(String s) {
        int N = s.length();
        if (N == 1) {
            return N;
        }

        int M = N / 2;
        int minLength = N;
        for (int len = 1; len <= M; len++) {
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0, len);
            int count = 1;
            int i = len;
            for (; i + len - 1 < N; i += len) {
                String next = s.substring(i, i + len);
                if (prev.equals(next)) {
                    count++;
                } else {
                    if (count > 1) {
                        sb.append(count);
                    }
                    sb.append(prev);
                    if (sb.length() > minLength) {
                        continue;
                    }

                    count = 1;
                    prev = next;
                }
            }

            if (i <= N) {
                if (count > 1) {
                    sb.append(count);
                }
                sb.append(prev);
            }
            if (i < N) {
                sb.append(s.substring(i));
            }

            if (sb.length() < minLength) {
                minLength = sb.length();
            }
        }

        return minLength;
    }

    public static int solution(String s) {
        int len = s.length(), lim = len / 2;
        String minString = s;

        for (int n = 1; n <= lim; n++) {
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0, n), next = "";
            int prevCnt = 0, i = 0;

            for (i = 0; i < len - n + 1; i += n) {
                next = s.substring(i, i + n);
                if (next.equals(prev)) {
                    prevCnt++;
                } else {
                    if (prevCnt != 1) {
                        sb.append(prevCnt);
                    }
                    sb.append(prev);
                    prev = next;
                    prevCnt = 1;
                }
            }

            if (prevCnt != 1) {
                sb.append(prevCnt);
            }
            sb.append(prev);

            if (i != len) {
                sb.append(s, i, len);
            }

            if (sb.length() < minString.length()) {
                minString = sb.toString();
            }
        }

        return minString.length();
    }
}
