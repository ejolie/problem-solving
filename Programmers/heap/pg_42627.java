package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * 디스크 컨트롤러
 */
public class pg_42627 {
    public static void main(String[] args) {
        int[][] jobs1 = {{0, 3}, {1, 9}, {2, 6}};
        int[][] jobs2 = {{0, 1}, {1, 2}, {600, 5}};
        assertEquals(solution(jobs1), 9);
    }

    // 한 번에 하나의 작업만 수행
    // 작업을 수행하고 있지 않을 땐 먼저 요청이 들어온 것부터 처리
    // return: 작업의 요청부터 종료까지 걸린 시간의 평균의 최솟값 -> Shortest Job First
    public static int solution(int[][] jobs) {
        int N = jobs.length;
        Queue<int[]> pqueue = new PriorityQueue<>(N, Comparator.comparingInt(j -> j[1]));
        Arrays.sort(jobs, Comparator.comparingInt(j -> j[0]));

        int currentTime = 0;
        int totalTime = 0;
        int endIdx = 0;
        while (endIdx < N || !pqueue.isEmpty()) {
            while (endIdx < N && jobs[endIdx][0] <= currentTime) {
                pqueue.add(jobs[endIdx]);
                endIdx++;
            }

            if (!pqueue.isEmpty()) {
                int[] job = pqueue.poll();
                currentTime += job[1];
                totalTime += currentTime - job[0];
            } else {
                currentTime = jobs[endIdx][0];
            }
        }

        return totalTime / jobs.length;
    }
}
