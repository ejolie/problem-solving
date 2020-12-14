package algorithm_practice_kit.stack_and_queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 기능개발
 */
public class pg_42586 {
    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new LinkedList<>();
        List<int[]> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            queue.add(new int[]{progresses[i], speeds[i]});
        }

        int day = 0;
        while (!queue.isEmpty()) {
            if ((queue.get(0)[0] + queue.get(0)[1] * day) >= 100) {
                int count = 0;
                while (!queue.isEmpty() && (queue.get(0)[0] + queue.get(0)[1] * day) >= 100) {
                    queue.remove(0);
                    count++;
                }
                result.add(count);
            }
            day++;
        }

        // List<Integer> -> int[]: result.stream().mapToInt(i -> i).toArray();
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
