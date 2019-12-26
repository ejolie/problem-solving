package src.java.problems;

/*
 * 20. Valid Parentheses (Easy)
 */
import java.util.Stack;
import java.util.HashMap;

public class Q20_1 {
    private HashMap<Character, Character> mappings;

    Q20_1() {
        mappings = new HashMap<>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (this.mappings.containsKey(ch)) {
                char top = stack.empty() ? '#' : stack.pop();

                if (top != this.mappings.get(ch)) {
                    return false;
                }
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }

}
