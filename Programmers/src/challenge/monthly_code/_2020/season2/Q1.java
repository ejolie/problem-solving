package challenge.monthly_code._2020.season2;

import java.util.*;

/**
 * 월간 코드 챌린지 시즌2(10월) - Q1
 */
public class Q1 {
    public static void main(String[] args) {
        System.out.println(solution(1));
    }

    public static int solution(int n) {
        if (n < 3) {
            return n;
        }

        Stack<Integer> stack = new Stack<>();
        int div = n;
        while (n >= 3) {
            div = n / 3;
            int mod = n % 3;
            stack.push(mod);
            n = div;
        }
        stack.push(div);

        int answer = 0;
        int p = 0;
        while (!stack.empty()) {
            answer += stack.pop() * Math.pow(3, p++);
        }

        return answer;
    }
}
