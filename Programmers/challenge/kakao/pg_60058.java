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
        return helper(p);
    }

    private static String helper(String str) {
        if ("".equals(str)) {
            return "";
        }
        if (isRightPair(str)) {
            return str;
        }

        int cnt = 0;
        int i = 0;
        for (; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                cnt++;
            } else {
                cnt--;
            }
            if (cnt == 0) {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        String u = str.substring(0, i + 1);
        String v = i + 2 > str.length() ? "" : str.substring(i + 1);
        String vReturn = helper(v);
        if (isRightPair(u)) {
            sb.append(u).append(vReturn);
        } else {
            sb.append("(").append(vReturn).append(")").append(trim(u));
        }

        return sb.toString();
    }

    private static boolean isRightPair(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                cnt++;
            } else {
                if (cnt == 0) {
                    return false;
                }
                cnt--;
            }
        }
        return cnt == 0;
    }

    private static String trim(String str) {
        if (str.length() < 2) {
            return str;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < str.length() - 1; i++) {
            if (str.charAt(i) == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }
        return sb.toString();
    }
}
