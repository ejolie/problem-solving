package lesson4;

public class MissingInteger {
    private static final int MAX_NUM = 1000000;

    public int solution(int[] A) {
        boolean[] counter = new boolean[MAX_NUM + 1];
        for (int num : A) {
            if (num > 0) {
                counter[num] = true;
            }
        }

        int answer = 1;
        for (int i = 1; i <= MAX_NUM; i++) {
            if (!counter[i]) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}
