package lesson5;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PassingCars {
    private static final long LIMIT = 1000000000L;

    public static void main(String[] args) {
        assertEquals(5, new PassingCars().solution(new int[]{0, 1, 0, 1, 1}));
        assertEquals(5, new PassingCars().solution_twoLoop(new int[]{0, 1, 0, 1, 1}));
    }

    // i=0, (0,1) (0,3) (0,4)
    // i=2, (2,3) (2,4)
    // west 만나기 전에 있었던 east 수 = east, west 조합 수
    public int solution(int[] A) {
        long answer = 0;
        long eastCount = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                eastCount++;
            } else {
                answer += eastCount;
            }
        }
        return answer > LIMIT ? -1 : (int) answer;
    }

    public int solution_twoLoop(int[] A) {
        int N = A.length;
        List<Integer> eastCars = new ArrayList<>(N);
        long count = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] == 0) {
                eastCars.add(i);
            }
        }

        int M = eastCars.size();
        for (int i = 0; i < M; i++) {
            count += (N - eastCars.get(i) - 1) - (M - i - 1);
        }

        return count > LIMIT ? -1 : (int) count;
    }
}
