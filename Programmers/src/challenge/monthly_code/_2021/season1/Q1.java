package challenge.monthly_code._2021.season1;

/**
 * 음양 더하기
 */
public class Q1 {

    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i = 0; i < absolutes.length; i++) {
            int num = signs[i] ? absolutes[i] : absolutes[i] * -1;
            answer += num;
        }
        return answer;
    }
}
