package interview_preparation_kit.warm_up_challenges.counting_valleys;

import java.io.*;

// 20 min
class Result {

    // 12
    // DDUUDDUDUUUD
    public static int countingValleys(int steps, String path) {
        int N = steps + 2;
        int[] heights = new int[N];

        for (int i = 0; i < steps; i++) {
            char step = path.charAt(i);
            if (step == 'U') {
                heights[i + 1] = heights[i] + 1;
            } else if (step == 'D') {
                heights[i + 1] = heights[i] - 1;
            }
        }

        int valley = 0;
        int prev = heights[0];
        for (int i = 1; i < N - 1; i++) {
            if (prev == 0 && heights[i] < 0) {
                valley++;
                while (heights[i] < 0 && i < N - 1) {
                    i++;
                }
            }
            prev = heights[i];
        }

        return valley;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
