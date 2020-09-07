package challenge.kakao;

/**
 * 2020 KAKAO BLIND RECRUITMENT - 문자열 압축
 */
public class pg_60057 {
    public static void main(String[] args) {
        String s = "aabbaccc";
        System.out.println(solution(s));
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
                sb.append(s.substring(i, len));
            }

            if (sb.length() < minString.length()) {
                minString = sb.toString();
            }
        }

        return minString.length();
    }
}