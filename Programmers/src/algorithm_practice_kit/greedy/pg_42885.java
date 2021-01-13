package algorithm_practice_kit.greedy;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 구명보트
 */
public class pg_42885 {
    public static void main(String[] args) {
        assertEquals(3, solution(new int[]{70, 50, 80, 50}, 100));
        assertEquals(3, solution(new int[]{70, 80, 50}, 100));
    }

    public static int solution(int[] people, int limit) {
        Arrays.sort(people);

        int l = 0, r = people.length - 1;
        while (l < r) {
            if (people[r] + people[l] <= limit) {
                l++;
            }
            r--;
        }

        return people.length - l;
    }
}
