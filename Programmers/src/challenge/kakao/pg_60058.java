package challenge.kakao;

/**
 * 2020 KAKAO BLIND RECRUITMENT - 괄호 변환
 */
public class pg_60058 {
    public static void main(String[] args) {
        System.out.println(solution("(()())()"));
        System.out.println(solution(")("));
        System.out.println(solution("()))((()"));
    }

    public static String solution(String p) {
        if ("".equals(p) || isCorrectPair(p)) {
            return p;
        }

        int idx = getBalancedPairIndex(p);
        String u = p.substring(0, idx + 1); // (())
        String v = idx + 1 == p.length() ? "" : p.substring(idx + 1); // )(

        StringBuilder sb = new StringBuilder();
        String vReturn = solution(v);
        if (isCorrectPair(u)) {
            sb.append(u).append(vReturn);
        } else {
            sb.append("(").append(vReturn).append(")").append(trimAndReverse(u));
        }
        return sb.toString();
    }

    private static boolean isCorrectPair(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                count++;
            } else {
                if (count == 0) {
                    return false;
                }
                count--;
            }
        }
        return count == 0;
    }

    private static int getBalancedPairIndex(String str) {
        int count = 0;
        int i = 0;
        for (; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                break;
            }
        }
        return i;
    }

    private static String trimAndReverse(String str) {
        if (str.length() < 2) {
            return str;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < str.length() - 1; i++) {
            if (str.charAt(i) == '(') {
                sb.append(")");
            } else {
                sb.append("(");
            }
        }
        return sb.toString();
    }

}
