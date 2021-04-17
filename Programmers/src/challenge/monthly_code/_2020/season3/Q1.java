package challenge.monthly_code._2020.season3;

public class Q1 {

    public int solution(int[] a, int[] b) {
        int answer = 0;
        for (int i = 0; i < a.length; i++) {
            answer += (a[i] * b[i]);
        }
        return answer;
    }
}
