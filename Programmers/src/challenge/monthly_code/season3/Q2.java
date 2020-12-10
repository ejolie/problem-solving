package challenge.monthly_code.season3;

public class Q2 {

    public int[] solution(String s) {
        int[] answer = {0, 0};
        change(s, answer);
        return answer;
    }

    private void change(String s, int[] answer) {
        if ("1".equals(s)) {
            return;
        }

        answer[0]++;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '1') {
                sb.append(ch);
            } else {
                answer[1]++;
            }
        }

        int len = sb.length();
        change(Integer.toBinaryString(len), answer);
    }
}
