package brute_force;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * 모의고사
 */
public class pg_42840 {
    public static void main(String[] args) {
        int[] answer = {1, 3, 2, 4, 2};
        int[] result = solution(answer);
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(int[] answers) {
        int[] A = {1, 2, 3, 4, 5};
        int[] B = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] C = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int cntA = 0;
        int cntB = 0;
        int cntC = 0;
        for (int i = 0; i < answers.length; i++) {
            if (A[i % 5] == answers[i]) cntA++;
            if (B[i % 8] == answers[i]) cntB++;
            if (C[i % 10] == answers[i]) cntC++;
        }

        int cntMax = Math.max(Math.max(cntA, cntB), cntC);
        List<Integer> list = new ArrayList<>();
        if (cntA == cntMax) list.add(1);
        if (cntB == cntMax) list.add(2);
        if (cntC == cntMax) list.add(3);

        return list.stream().mapToInt(i -> i).toArray();
    }
}
