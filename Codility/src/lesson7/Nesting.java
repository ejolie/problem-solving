package lesson7;

import java.util.ArrayDeque;
import java.util.Deque;

public class Nesting {
    public int solution(String S) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < S.length(); i++) {
            char p = S.charAt(i);
            if (p == '(') {
                stack.push(p);
            } else {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return 0;
                }
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
