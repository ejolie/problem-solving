package binary_search;

/**
 * 입국심사
 */
public class pg_43238 {
    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10};
        System.out.println(solution(n, times));
    }

    public static long solution(int n, int[] times) {
        long lo = 1;
        long hi = getUpperBound(times) * n;
        long answer = hi;

        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            long totalPeople = getTotalPeople(times, mid);

            if (totalPeople >= n) {
                answer = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return answer;
    }

    private static long getTotalPeople(int[] times, long totalTime) {
        long totalPeople = 0;
        for (int time : times) {
            totalPeople += totalTime / time;
        }
        return totalPeople;
    }

    private static long getUpperBound(int[] times) {
        long max = 0;
        for (int time : times) {
            if (time > max) max = time;
        }
        return max;
    }
}
