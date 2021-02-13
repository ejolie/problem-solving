package lesson2;

public class CyclicRotation {
    public int[] solution(int[] A, int K) {
        int N = A.length;
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            int index = (i + K) % N;
            result[index] = A[i];
        }
        return result;
    }
}