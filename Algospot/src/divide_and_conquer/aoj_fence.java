package divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 울타리 잘라내기 (난이도: 중)
 * <p>
 * 1. 어떻게 분할할지
 * - n개의 판자를 절반으로 나눠 두 개의 부분문제를 만든다. 이때 최대 직사각형은 다음 세 가지 중 하나에 속한다.
 * 1) 가장 큰 직사각형을 왼쪽 부분 문제에서만 잘라낼 수 있다.
 * 2) 가장 큰 직사각형을 오른쪽 부분 문제에서만 잘라낼 수 있다.
 * 3) 가장 큰 직사각형은 왼쪽 부분 문제와 오른쪽 부분 문제에 걸쳐 있다.
 */
public class aoj_fence {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n = 0;
    static int[] heights;

    public static void main(String[] args) throws IOException {
        int cases = Integer.parseInt(br.readLine().trim());

        while (cases-- > 0) {
            n = Integer.parseInt(br.readLine().trim());
            heights = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for (int i = 0; i < n; i++) {
                heights[i] = Integer.parseInt(st.nextToken());
            }

            int answer = divideAndConquer(0, n);
            System.out.println(answer);
        }
    }

    public static int bruteForce() {
        int maxSize = 0;
        for (int left = 0; left < n; left++) {
            int minHeight = heights[left];
            for (int right = left; right < n; right++) {
                minHeight = Math.min(minHeight, heights[right]);
                maxSize = Math.max(maxSize, minHeight * (right - left + 1));
            }
        }
        return maxSize;
    }

    public static int divideAndConquer(int left, int right) {
        // base case: 판자가 하나밖에 없는 경우
        if (left == right) {
            return heights[left];
        }

        // 두 구간으로 문제를 분할한다. -> divide
        int mid = (left + right) / 2;

        // 부분 문제 1. 왼쪽 부분에 속하는 사각형 중 가장 큰 것을 찾는다.
        int leftMaxSize = divideAndConquer(left, mid);
        // 부분 문제 2. 오른쪽 부분에 속하는 사각형 중 가장 큰 것을 찾는다.
        int rightMaxSize = divideAndConquer(mid + 1, right);
        // 부문 문제 1과 2의 결괏값을 병합
        int maxSize = Math.max(leftMaxSize, rightMaxSize);

        // 부분 문제 3. 두 부분에 모두 걸치는 사각형 중 가장 큰 것을 찾는다.
        int lo = mid;
        int hi = mid + 1;
        int minHeight = Math.min(heights[lo], heights[hi]);
        // [mid, mid+1]만 포함하는 너비 2인 사각형을 고려한다.
        maxSize = Math.max(maxSize, minHeight * 2);

        // 사각형이 입력 전체를 덮을 때까지 확장해 나간다.
        while (left < lo || hi < right) {
            // 항상 높이가 더 높은 쪽으로 확장한다.
            if (hi < right && (lo == left || heights[lo - 1] < heights[hi + 1])) {
                ++hi;
                minHeight = Math.min(minHeight, heights[hi]);
            } else {
                --lo;
                minHeight = Math.min(minHeight, heights[lo]);
            }
            // 확장한 후 사각형의 넓이
            maxSize = Math.max(maxSize, minHeight * (hi - lo + 1));
        }

        return maxSize;
    }
}
