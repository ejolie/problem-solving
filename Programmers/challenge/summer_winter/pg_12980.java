package challenge.summer_winter;

/**
 * 점프와 순간 이동
 */
public class pg_12980 {
    public static void main(String[] args) {
        int n = 11;
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int ans = 0;
        while (n > 0) {
            ans += n % 2;
            n /= 2;
        }
        return ans;
    }
}