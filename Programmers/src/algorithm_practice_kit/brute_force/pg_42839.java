package algorithm_practice_kit.brute_force;

import java.util.HashSet;
import java.util.Set;

/**
 * 소수 찾기
 */
public class pg_42839 {
    public static void main(String[] args) {
        String numbers = "011";
        System.out.println(solution(numbers));
    }

    public static int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        Set<Integer> set = new HashSet<>();
        for (int r = 1; r <= numbers.length(); r++) {
            backtrack(numbers.toCharArray(), "", r, 0, visited, set);
        }
        return set.size();
    }

    private static void backtrack(char[] numbers, String num, int r, int depth, boolean[] visited,
                                  Set<Integer> set) {
        if (r == depth) {
            int intNum = Integer.parseInt(num);
            if (isPrime(intNum))
                set.add(intNum);
            return;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            backtrack(numbers, num + numbers[i], r, depth + 1, visited, set);
            visited[i] = false;
        }
    }

    private static boolean isPrime(int num) {
        if (num <= 1)
            return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
