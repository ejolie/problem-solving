package challenge.kakao;

/**
 * 2020 KAKAO BLIND RECRUITMENT - 자물쇠와 열쇠
 */
public class pg_60059 {
    public static void main(String[] args) {
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(solution(key, lock));
    }

    public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        return answer;
    }

    private static int[][] rotate(int[][] arr, int degree) {
        int N = arr.length;
        int M = arr[0].length;
        int[][] result = new int[N][M];

        if (degree == 90) {

        }

        return null;
    }
}

// 4 회전 * N^4 이동
