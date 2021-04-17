package challenge.monthly_code._2021.season1;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 괄호 회전하기
 */
public class Q2 {

    public static void main(String[] args) {
        Q2 q2 = new Q2();
        assertEquals(2, q2.solution("}]()[{"));
    }

    public int solution(String s) {
        int x = 0;
        List<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }
        for (int shift = 0; shift < s.length(); shift++) {
            x += check(list);
        }
        return x;
    }

    private int check(List<Character> list) {
        list.add(list.remove(0));
        return isValid(list) ? 1 : 0;
    }

    private boolean isValid(List<Character> list) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : list) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char top = stack.pop();
                    if (top == '(' && ch != ')') {
                        return false;
                    }
                    if (top == '[' && ch != ']') {
                        return false;
                    }
                    if (top == '{' && ch != '}') {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
