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
        assertEquals(2, solution(new int[]{10, 10, 20, 100}, 100));
    }

    public static int solution(int[] people, int limit) {
        Arrays.sort(people);

        int l = 0, r = people.length - 1;
        int boats = 0;
        int weight = 0;
        while (l <= r) {
            weight += people[r];
            while (l <= r && weight + people[l] <= limit) {
                weight += people[l++];
            }
            boats++;
            weight = 0;
            r--;
        }

        return boats;
    }
}
