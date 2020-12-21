package algorithm_practice_kit.brute_force;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 소수 찾기
 */
public class pg_42839 {

    public static void main(String[] args) {
        assertTrue(isPrime(2));
        assertEquals(3, solution("17"));
        assertEquals(2, solution("011"));
    }

    // ================================ new ================================
    public static int solution(String numbers) {
        Set<Integer> primeSet = new HashSet<>();
        List<Character> tempNum = new LinkedList<>();

        for (int r = 1; r <= numbers.length(); r++) {
            findPrime(numbers.toCharArray(), r, tempNum, primeSet);
        }

        return primeSet.size();
    }

    private static void findPrime(char[] numbers, int r, List<Character> tempNum, Set<Integer> primeSet) {
        if (tempNum.size() == r) {
            int num = 0;
            for (char ch : tempNum) {
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

            tempNum.add(num);
            numbers[i] = '#';

            findPrime(numbers, r, tempNum, primeSet);

            tempNum.remove(tempNum.size() - 1);
            numbers[i] = num;
        }
    }

    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) { // i <= Math.sqrt(num);
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    // ================================ old ================================
    public static int solution_old(String numbers) {
        Set<Integer> primeSet = new HashSet<>();
        boolean[] visited = new boolean[numbers.length()];

        for (int r = 1; r <= numbers.length(); r++) {
            findPrime_old(numbers.toCharArray(), r, 0, visited, "", primeSet);
        }

        return primeSet.size();
    }

    private static void findPrime_old(char[] numbers, int r, int depth, boolean[] visited, String tempNum, Set<Integer> primeSet) {
        if (r == depth) {
            int intNum = Integer.parseInt(tempNum);

            if (isPrime(intNum)) {
                primeSet.add(intNum);
            }
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            findPrime_old(numbers, r, depth + 1, visited, tempNum + numbers[i], primeSet);
            visited[i] = false;
        }
    }

}
