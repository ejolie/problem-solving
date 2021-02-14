package lesson4;

public class FrogRiverOne {

    // 100%
    public int solution_n(int X, int[] A) {
        int N = A.length;
        boolean[] leaves = new boolean[X + 1];
        int currSum = 0;
        int totalPosSum = X * (X + 1) / 2;
        for (int time = 0; time < N; time++) {
            int pos = A[time];
            if (!leaves[pos]) {
                leaves[pos] = true;
                currSum += pos;
            }
            if (currSum == totalPosSum) {
                return time;
            }
        }
        return -1;
    }

    // 81%
    public int solution_nSquare(int X, int[] A) {
        int N = A.length;
        boolean[] leaves = new boolean[X + 1];
        for (int time = 0; time < N; time++) {
            leaves[A[time]] = true;
            if (doesExistAllLeaves(leaves, X)) {
                return time;
            }
        }
        return -1;
    }

    private boolean doesExistAllLeaves(boolean[] leaves, int X) {
        for (int i = 1; i <= X; i++) {
            if (!leaves[i]) {
                return false;
            }
        }
        return true;
    }
}
