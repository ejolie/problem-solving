package src;

import java.util.Scanner;

/**
 * 수들의 합 2
 */
public class boj2003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long M = sc.nextLong();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(solution(N, M, arr));
    }

    public static int solution(int N, long M, int[] arr) {
        int count = 0;
        long sum = 0;
        int end = 0;
        for (int start = 0; start < N; start++) {
            while (sum < M && end < N) {
                sum += arr[end++];
            }
            if (sum == M) {
                count++;
            }
            sum -= arr[start];
        }

        return count;
    }
}
