package interview_preparation_kit.warm_up_challenges.jumping_on_the_clouds;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

// 13 min
class Result {
    public static int jumpingOnClouds(List<Integer> c) {
        int N = c.size();
        int[] jumps = new int[N];
        jumps[1] = c.get(1) == 1 ? Integer.MAX_VALUE : 1;
        for (int i = 2; i < N; i++) {
            if (c.get(i) == 1) {
                jumps[i] = Integer.MAX_VALUE;
            } else {
                jumps[i] = Math.min(jumps[i-1], jumps[i-2]) + 1;
            }
        }
        return jumps[N - 1];
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}