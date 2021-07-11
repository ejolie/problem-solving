import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 9935. 문자열 폭발
 */
public class boj9935 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();
        System.out.println(explode(str, bomb));
    }

    public static String explode(String str, String bomb) {
        Stack<Character> stack = new Stack<>();
        int N = str.length();
        int M = bomb.length();

        for (int i = 0; i < N; i++) {
            stack.push(str.charAt(i));

            if (stack.size() >= M && stack.peek() == bomb.charAt(M - 1)) {
                int j = 0;
                for (; j < M; j++) {
                    if (bomb.charAt(M - 1 - j) != stack.get(stack.size() - 1 - j)) {
                        break;
                    }
                }
                if (j >= M) {
                    while (j-- > 0) {
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.length() == 0 ? "FRULA" : result.reverse().toString();
    }
}
