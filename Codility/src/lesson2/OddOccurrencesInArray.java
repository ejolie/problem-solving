package lesson2;

import java.util.HashMap;
import java.util.Map;

public class OddOccurrencesInArray {
    public int solution(int[] A) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : A) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        int unpaired = 0;
        for (int num : counter.keySet()) {
            if (counter.get(num) % 2 != 0) {
                unpaired = num;
                break;
            }
        }
        return unpaired;
    }
}
