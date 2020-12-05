package heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * 이중우선순위큐
 */
public class pg_42628 {

    public static void main(String[] args) {
        String[] operations1 = {"I 16", "D 1"};
        String[] operations2 = {"I 7", "I 5", "I -5", "D -1"};
        assertArrayEquals(solution(operations1), new int[]{0, 0});
        assertArrayEquals(solution(operations2), new int[]{7, 5});
    }

    public static int[] solution(String[] operations) {
        Queue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> minQ = new PriorityQueue<>();

        for (String op : operations) {
            String[] ops = op.split(" ");
            String command = ops[0];
            int num = Integer.parseInt(ops[1]);

            if ("I".equals(command)) {
                maxQ.add(num);
                minQ.add(num);
            } else if ("D".equals(command)) {
                if (maxQ.isEmpty() || minQ.isEmpty()) {
                    continue;
                }
                if (num == 1) {
                    int max = maxQ.peek();
                    maxQ.remove(max);
                    minQ.remove(max);
                } else if (num == -1) {
                    int min = minQ.peek();
                    maxQ.remove(min);
                    minQ.remove(min);
                }
            }
        }

        if (maxQ.isEmpty() && minQ.isEmpty()) {
            return new int[]{0, 0};
        }
        return new int[]{maxQ.poll(), minQ.poll()};
    }
}
