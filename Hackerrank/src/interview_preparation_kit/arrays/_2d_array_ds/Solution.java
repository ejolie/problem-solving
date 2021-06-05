package interview_preparation_kit.arrays._2d_array_ds;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

// 11 min
class Result {

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> arr) {
        List<Integer> sums = new ArrayList<>(16);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int sum = 0;
                sum += arr.get(i).get(j);
                sum += arr.get(i).get(j + 1);
                sum += arr.get(i).get(j + 2);
                sum += arr.get(i + 1).get(j + 1);
                sum += arr.get(i + 2).get(j);
                sum += arr.get(i + 2).get(j + 1);
                sum += arr.get(i + 2).get(j + 2);
                sums.add(sum);
            }
        }

        int maxSum = Integer.MIN_VALUE;
        for (int sum : sums) {
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}