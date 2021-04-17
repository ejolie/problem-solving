package challenge.monthly_code._2020.season1;

import java.util.*;

/**
 * 월간 코드 챌린지 시즌1(9월) - Q1
 */
public class Q1 {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        int[] answer = new int[set.size()];
        int i = 0;
        for (int num : set) {
            answer[i++] = num;
        }
        return answer;
    }
}
