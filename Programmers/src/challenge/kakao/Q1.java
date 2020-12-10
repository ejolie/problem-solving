package challenge.kakao;

public class Q1 {

    public static void main(String[] args) {
        System.out.println(solution("...!@BaT#*..y.abcdefghijklm") + " == bat.y.abcdefghi");
        System.out.println(solution("z-+.^.") + " == z--");
        System.out.println(solution("=.=") + " == aaa");
        System.out.println(solution("123_.def") + " == 123_.def");
        System.out.println(solution("abcdefghijklmn.p") + " == abcdefghijklmn");
    }

    public static String solution(String new_id) {
        StringBuilder sb = new StringBuilder();

        if (new_id.isBlank()) {
            sb.append("aaa");
        } else {
            new_id = new_id.toLowerCase();
            new_id = new_id.replaceAll("[^a-z0-9\\-\\.\\_]", "");
            new_id = new_id.replaceAll("\\.{2,}", ".");

            sb.append(new_id);
            trim(sb);

            if (sb.length() >= 16) {
                sb.delete(15, sb.length());
                trim(sb);
            } else if (sb.length() <= 2) {
                char lastChar = sb.charAt(sb.length() - 1);
                while (sb.length() != 3) {
                    sb.append(lastChar);
                }
            }

        }

        return sb.toString();
    }

    private static void trim(StringBuilder sb) {
        if (sb.charAt(0) == '.') {
            sb.delete(0, 1);
        }
        if (sb.length() == 0) {
            sb.append("a");
            return;
        }
        if (sb.charAt(sb.length() - 1) == '.') {
            sb.delete(sb.length() - 1, sb.length());
        }
    }
}
