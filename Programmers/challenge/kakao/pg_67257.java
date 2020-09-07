package challenge.kakao;

import java.util.LinkedList;
import java.util.List;

/**
 * 2020 카카오 인턴십 - 수식 최대화
 */
public class pg_67257 {

    private static final char[] OPS = { '+', '*', '-' };
    private static List<List<Character>> orders = new LinkedList<>();
    private static List<Long> nums = new LinkedList<>();
    private static List<Character> ops = new LinkedList<>();

    public static void main(String[] args) {
        String expression = "100-200*300-500+20";
        long result = solution(expression);
        System.out.println(result);
    }

    public static long solution(String expression) {
        permutation(new LinkedList<>());

        long prevNum = 0l;
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (Character.isDigit(ch)) {
                prevNum = prevNum * 10 + ch - '0';
            } else {
                nums.add(prevNum);
                prevNum = 0l;
                ops.add(ch);
            }
        }
        nums.add(prevNum);

        long answer = 0;
        for (List<Character> order : orders) {
            long sum = calculate(order, expression);
            answer = Math.max(answer, Math.abs(sum));
        }

        return answer;
    }

    private static long calculate(List<Character> order, String expression) {
        List<Long> numsCopy = new LinkedList<>(nums);
        List<Character> opsCopy = new LinkedList<>(ops);
        for (int i = 0; i < order.size(); i++) {
            for (int j = 0; j < opsCopy.size(); j++) {
                if (order.get(i) == opsCopy.get(j)) {
                    long result = helper(opsCopy.get(j), numsCopy.get(j), numsCopy.get(j + 1));
                    opsCopy.remove(j);
                    numsCopy.set(j, result);
                    numsCopy.remove(j + 1);
                    j--;
                }
            }
        }

        return numsCopy.get(0);
    }

    private static long helper(char op, long num1, long num2) {
        if (op == '-')
            return num1 - num2;
        else if (op == '+')
            return num1 + num2;
        else
            return num1 * num2;
    }

    private static void permutation(List<Character> perm) {
        if (perm.size() == OPS.length) {
            orders.add(new LinkedList<>(perm));
        } else {
            for (int i = 0; i < OPS.length; i++) {
                if (perm.contains(OPS[i]))
                    continue;
                perm.add(OPS[i]);
                permutation(perm);
                perm.remove(perm.size() - 1);
            }
        }
    }
}