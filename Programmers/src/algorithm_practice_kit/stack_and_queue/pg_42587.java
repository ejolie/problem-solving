package algorithm_practice_kit.stack_and_queue;

import java.util.Queue;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 프린터
 */
public class pg_42587 {
    public static void main(String[] args) {
        int[] priorities1 = {2, 1, 3, 2};
        int location1 = 2;

        int[] priorities2 = {1, 1, 9, 1, 1, 1};
        int location2 = 0;

        assertEquals(1, solution(priorities1, location1));
        assertEquals(5, solution(priorities2, location2));
    }

    public static int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[]{i, priorities[i]});
        }

        int order = 0;
        while (!queue.isEmpty()) {
            int[] head = queue.poll();
            boolean isFound = false;

            for (int[] item : queue) {
                if (item[0] == head[0]) {
                    continue;
                }
                if (item[1] > head[1]) {
                    queue.add(head);
                    isFound = true;
                    break;
                }
            }

            if (!isFound) {
                order++;
                if (head[0] == location) {
                    return order;
                }
            }
        }

        return order;
    }
}
