package lesson7;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class Brackets {

    private static final Map<Character, Character> pair = Map.of(
            '(', ')',
            '[', ']',
            '{', '}'
    );

    public int solution(String S) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < S.length(); i++) {
            char p = S.charAt(i);
            if (pair.containsKey(p)) {
                stack.push(p);
            } else {
                if (stack.isEmpty() || p != pair.getOrDefault(stack.pop(), ' ')) {
                    return 0;
                }
            }
        }
        return stack.isEmpty() ? 0 : 1;
    }
}
