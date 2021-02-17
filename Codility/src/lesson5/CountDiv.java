package lesson5;

public class CountDiv {
    public int solution(int A, int B, int K) {
        int firstNum = -1;
        for (int i = A; i <= B; i++) {
            if (i % K == 0) {
                firstNum = i;
                break;
            }
        }

        if (firstNum == -1) {
            return 0;
        }

        int count = (B - firstNum) / K + 1;
        return count;
    }
}
