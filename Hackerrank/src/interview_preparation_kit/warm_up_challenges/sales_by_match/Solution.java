package interview_preparation_kit.warm_up_challenges.sales_by_match;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

// 6 min
class Result {

    public static int sockMerchant(int n, List<Integer> ar) {
        int pair = 0;
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : ar) {
            int count = counter.getOrDefault(num, 0);
            if (count == 0) {
                counter.put(num, 1);
            } else if (count > 0) {
                counter.put(num, count - 1);
                pair++;
            }
        }
        return pair;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
