package algorithm_practice_kit.sorting;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * K번째수
 */
public class pg_42748 {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}
        };

        assertArrayEquals(new int[]{5, 6, 3}, solution_sort(array, commands));
        assertArrayEquals(new int[]{5, 6, 3}, solution_quickSelect(array, commands));
    }

    // average: O(nlogn)
    public static int[] solution_sort(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1];
            int k = commands[i][2] - 1;
            int[] subArray = Arrays.copyOfRange(array, start, end);

            Arrays.sort(subArray);
            answer[i] = subArray[k];
        }

        return answer;
    }

    // average: O(n), worst: O(n^2)
    public static int[] solution_quickSelect(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < answer.length; i++) {
            int left = commands[i][0] - 1;
            int right = commands[i][1];
            int k = commands[i][2] - 1;
            int[] subArray = Arrays.copyOfRange(array, left, right);

            answer[i] = quickSelect(subArray, 0, subArray.length - 1, k);
        }

        return answer;
    }

    private static int quickSelect(int[] arr, int left, int right, int k) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);

            if (pivotIndex == k) {
                return arr[k];
            } else if (pivotIndex > k) {
                return quickSelect(arr, left, pivotIndex - 1, k);
            } else {
                return quickSelect(arr, pivotIndex + 1, right, k);
            }
        }

        return arr[left];
    }

    private static int partition(int[] arr, int start, int right) {
        int pivot = arr[right];
        int i = start - 1; // i: 1구역(arr[i] < pivot)의 끝 지점

        for (int j = start; j <= right - 1; j++) { // j: 3구역(아직 정해지지 않은 원소들)의 시작 지점
            if (arr[j] <= pivot) {
                swap(arr, ++i, j);
            }
        }
        swap(arr, i + 1, right);

        return i + 1;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
