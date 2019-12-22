package src.problems;
/*
 * 7. Reverse Integer
 * Easy
 */

public class Q7 {
    public static void main(String[] args) {
        int x = 2147483647;
        System.out.println(reverse(x));
    }

    public static int reverse(int x) {
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x *= -1;
        }
        String str = Integer.toString(x);
        StringBuffer buff = new StringBuffer();
        buff.append(str);
        String reversed = buff.reverse().toString();

        int answer = 0;
        try {
            answer = Integer.parseInt(reversed);
            if (isNegative) {
                answer *= -1;
            }
        } catch (RuntimeException e) {
            answer = 0;
        }
        return answer;
    }

}
