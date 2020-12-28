package algorithm_practice_kit.greedy;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 조이스틱
 */
public class pg_42860 {
    public static void main(String[] args) {
        assertEquals(11, solution("JAZ"));
        assertEquals(56, solution("JEROEN"));
        assertEquals(23, solution("JAN"));
        assertEquals(9, solution("BBBAAAB")); // 왼쪽 == 오른쪽 -> 오른쪽
        assertEquals(11, solution("ABABAAAAABA"));
    }

    public static int solution(String name) {
        int N = name.length();
        char[] word = new char[N];
        Arrays.fill(word, 'A');

        int operations = 0, currIndex = 0;
        while (!String.valueOf(word).equals(name)) {
            // 1. up or down 결정
            char alphabet = name.charAt(currIndex);
            int up = alphabet - 'A';
            int down = 'Z' - alphabet + 1;

            // up, down 중 더 적은 조작 횟수를 더함
            operations += Math.min(up, down);
            word[currIndex] = alphabet;

            // 2. right or left 결정
            for (int move = 1; move < N; move++) {
                int right = (currIndex + move) % N;
                int left = ((currIndex - move) + N) % N;

                if (word[right] != name.charAt(right)) {
                    // 오른쪽 이동 시 먼저 발견 -> 오른쪽 이동이 더 적은 조작 횟수임
                    currIndex = right;
                    operations += move;
                    break;
                } else if (word[left] != name.charAt(left)) {
                    // 왼쪽 이동 시 먼저 발견 -> 왼쪽 이동이 더 적은 조작 횟수임
                    currIndex = left;
                    operations += move;
                    break;
                }
            }
        }

        return operations;
    }
}
