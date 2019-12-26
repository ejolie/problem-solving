package src.java.problems;

/*
 * 20. Valid Parentheses (Easy)
 */
import java.util.Stack;

public class Q20 {
    public static void main(String[] args) {
        String s = "([)]";
        System.out.println(isValid(s));
    }

    public static boolean isMatch(char top, char ch2) {
        switch (top) {
        case '(':
            return ch2 == ')';
        case '[':
            return ch2 == ']';
        case '{':
            return ch2 == '}';
        default:
            return false;
        }

    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (stack.isEmpty() || ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                char top = stack.pop();
                if (!isMatch(top, ch)) {
                    return false;
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }
}