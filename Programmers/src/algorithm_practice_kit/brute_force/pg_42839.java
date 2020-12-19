package algorithm_practice_kit.brute_force;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 소수 찾기
 */
public class pg_42839 {

    public static void main(String[] args) {
        assertEquals(3, solution("17"));
        assertEquals(2, solution("011"));
    }

    public static int solution(String numbers) {
        Set<Integer> primeSet = new HashSet<>();
        List<Character> tempPrime = new LinkedList<>();

        for (int r = 1; r <= numbers.length(); r++) {
            findPrime(numbers.toCharArray(), r, tempPrime, primeSet);
        }

        return primeSet.size();
    }

    private static void findPrime(char[] numbers, int r, List<Character> tempPrime, Set<Integer> primeSet) {
        if (tempPrime.size() == r) {
            int num = 0;
            for (char ch : tempPrime) {
                num *= 10;
                num += ch - '0';
            }
            if (isPrime(num)) {
                primeSet.add(num);
            }
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            char num = numbers[i];
            if (num == '#') {
                continue;
            }

            tempPrime.add(num);
            numbers[i] = '#';

            findPrime(numbers, r, tempPrime, primeSet);

            tempPrime.remove(tempPrime.size() - 1);
            numbers[i] = num;
        }
    }

    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    // ================================ old ================================
    public static int solution_old(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        Set<Integer> set = new HashSet<>();

        for (int r = 1; r <= numbers.length(); r++) {
            findPrime_old(numbers.toCharArray(), "", r, 0, visited, set);
        }

        return set.size();
    }

    private static void findPrime_old(char[] numbers, String num, int r, int depth, boolean[] visited,
                                      Set<Integer> set) {
        if (r == depth) {
            int intNum = Integer.parseInt(num);
            if (isPrime(intNum)) {
                set.add(intNum);
            }
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            findPrime_old(numbers, num + numbers[i], r, depth + 1, visited, set);
            visited[i] = false;
        }
    }

}
