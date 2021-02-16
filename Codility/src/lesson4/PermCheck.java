package lesson4;

public class PermCheck {
    public int solution(int[] A) {
        int N = A.length;
        boolean[] check = new boolean[N + 1];
        for (int num : A) {
            if (num > N) {
                return 0;
            }
            check[num] = true;
        }

        for (int i = 1; i <= N; i++) {
            if (!check[i]) {
                return 0;
            }
        }
        return 1;
    }
}
