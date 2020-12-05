package heap;

import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 더 맵게
 */
public class pg_42626 {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        assertEquals(solution(scoville, K), 2);
    }

    // 모든 음식의 스코빌 지수가 K 이상이 될 때 까지
    // new 스코빌 지수 = 1st min 스코빌 지수 + (2nd min 스코빌 지수 * 2)
    public static int solution(int[] scoville, int K) {
        Queue<Integer> pqueue = new PriorityQueue<>(scoville.length);
        for (int sc : scoville) {
            pqueue.add(sc);
        }

        int count = 0;
        while (!pqueue.isEmpty()) {
            if (pqueue.peek() >= K) {
                return count;
            }
            if (pqueue.size() < 2) {
                break;
            }
            count++;
            int newScoville = pqueue.poll() + (pqueue.poll() * 2);
            pqueue.add(newScoville);
        }

        return -1;
    }

    public static int solution_old(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> queue = new PriorityQueue<Integer>();
        for (int num : scoville) {
            queue.add(num);
        }
        while (!queue.isEmpty()) {
            int a = queue.poll();
            if (a >= K) {
                break;
            }
            if (queue.isEmpty()) {
                answer = -1;
                break;
            }
            int b = queue.poll();
            int c = a + b * 2;
            queue.add(c);
            answer++;
        }
        return answer;
    }
}
