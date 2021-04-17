package lesson8;

import java.util.HashMap;
import java.util.Map;

public class Leader {

    public int solution(int[] A) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : A) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        int half = A.length / 2;
        int domValue = -1;
        for (int num : counter.keySet()) {
            if (counter.get(num) > half) {
                domValue = num;
                break;
            }
        }

        int domIndex = -1;
        if (domValue != -1) {
            for (int i = 0; i < A.length; i++) {
                if (A[i] == domValue) {
                    domIndex = i;
                    break;
                }
            }
        }
        return domIndex;
    }
}
