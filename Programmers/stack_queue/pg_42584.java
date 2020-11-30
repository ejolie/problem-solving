package stack_queue;

import java.util.Arrays;
import java.util.Stack;

/**
 * 주식가격
 */
public class pg_42584 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3, 3, 1}; // {6, 5, 1, 3, 2, 1, 0}
        System.out.println(Arrays.toString(solution_stack(prices)));

        int[] max_tc = new int[100000]; // {9, 9, 9, 9, 9, 9, 9, ..., 9, 0}
        for (int i = 0; i < max_tc.length - 1; i++) {
            max_tc[i] = 9;
        }
        System.out.println(solution_stack(max_tc).length);
        // System.out.println(solution_bruteforce(max_tc).length); // Runtime Error
    }

    public static int[] solution_bruteforce(int[] prices) {
        int N = prices.length;
        int[] answer = new int[N];

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                answer[i]++;
                if (prices[i] > prices[j]) {
                    break;
                }
            }
        }

        return answer;
    }

    public static int[] solution_stack(int[] prices) {
        int N = prices.length;
        int[] answer = new int[N];
        Stack<Integer> stack = new Stack<>(); // index만 저장

        for (int i = 0; i < N; i++) { // O(n)
            while (!stack.empty() && prices[stack.peek()] > prices[i]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
        }

        while (!stack.empty()) { // O(n)
            int idx = stack.pop();
            answer[idx] = N - 1 - idx;
        }

        return answer;
    }

    // 1. 가격이 떨어지지 않는 기간 = prices[a]보다 작은 최초의 prices[b]를 발견할 때까지 (a < b, a는 b보다 뒤에 위치)
    // 2. prices[a]보다 작은지 판단하기 위해 value를, 기간을 계산하기 위해 index를 알아야 함 -> 스택에 같이 저장
    //
    // prices = {1, 2, 3, 2, 3, 3, 1}
    // answer = {6, 5, 1, 3, 2, 1, 0}
    public static int[] solution_stack_old(int[] prices) {
        int N = prices.length;
        int[] answer = new int[N];
        Stack<int[]> stack = new Stack<>(); // {index, prices[index]} 형태로 저장

        for (int i = 0; i < N; i++) {
            int price = prices[i];
            if (!stack.empty() && stack.peek()[1] <= price) {
                stack.push(new int[] {i, price});
            } else {
                // price(prices[b])는 앞에 나온 어떤 prices[a] 보다 작은 최초의 원소다.
                // prices[a]가 여럿일 수도 있으니 while 조건문으로 계속 pop
                while (!stack.empty() && stack.peek()[1] > price) {
                    int idx = stack.pop()[0]; // a
                    answer[idx] = i - idx;
                }
                stack.push(new int[] {i, price});
            }
        }

        // 0 ~ N까지 순회했는데도 계속 가격이 유지된 애들
        while (!stack.empty()) {
            int idx = stack.pop()[0];
            answer[idx] = N - 1 - idx; // 마지막 인덱스 - a
        }

        return answer;
    }
}
