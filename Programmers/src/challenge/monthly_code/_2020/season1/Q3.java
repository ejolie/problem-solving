package challenge.monthly_code._2020.season1;

/**
 * 월간 코드 챌린지 시즌1(9월) - Q3
 */
public class Q3 {
    public static void main(String[] args) {
        // int[] a = {-16, 27, 65, -2, 58, -92, -71, -68, -61, -33};
        int[] a = {9, -1, -5};
        System.out.println(solution(a));
    }

    public static int solution(int[] a) {
        int[] leftMinNums = new int[a.length];
        int[] rightMinNums = new int[a.length];
        int tempMin = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < tempMin) {
                tempMin = a[i];
            }
            leftMinNums[i] = tempMin;
        }

        tempMin = Integer.MAX_VALUE;
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] < tempMin) {
                tempMin = a[i];
            }
            rightMinNums[i] = tempMin;
        }

        int answer = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > leftMinNums[i] && a[i] > rightMinNums[i]) {
                answer++;
            }
        }
        return a.length - answer;
    }

    public static int solution_bruteforce(int[] a) {
        int answer = 0;
        for (int i = 0; i < a.length; i++) {
            int num = a[i];
            int count = 0;
            for (int j = 0; j < i; j++) {
                if (a[j] < num) {
                    count++;
                    break;
                }
            }
            if (count != 1) {
                continue;
            }

            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < num) {
                    count++;
                    break;
                }
            }
            if (count == 2) {
                answer++;
            }
        }
        return a.length - answer;
    }
}
