package lesson3;

public class PermMissingElem {
    public int solution(int[] A) {
        int N = A.length;
        long expectedSum = (long) (N + 1) * (N + 2) / 2;
        long missingSum = 0L;
        for (int num : A) {
            missingSum += num;
        }
        return (int) (expectedSum - missingSum);
    }

    public int solution_array(int[] A) {
        int N = A.length;
        boolean[] check = new boolean[N + 2];
        for (int num : A) {
            check[num] = true;
        }

        int missing = -1;
        for (int num = 1; num <= N + 1; num++) {
            if (!check[num]) {
                missing = num;
                break;
            }
        }
        return missing;
    }
}
