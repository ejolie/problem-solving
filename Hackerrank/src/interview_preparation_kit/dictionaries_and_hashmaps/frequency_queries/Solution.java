package interview_preparation_kit.dictionaries_and_hashmaps.frequency_queries;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        Map<Integer, Integer> numberMap = new HashMap<>();
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (List<Integer> query : queries) {
            int op = query.get(0);
            int num = query.get(1);
            if (op == 1) {
                int freq = numberMap.getOrDefault(num, 0);
                numberMap.put(num, freq + 1);
                if (freq > 0) {
                    freqMap.put(freq, freqMap.get(freq) - 1);
                }
                freqMap.put(freq + 1, freqMap.getOrDefault(freq + 1, 0) + 1);
            } else if (op == 2) {
                if (!numberMap.containsKey(num) || numberMap.get(num) <= 0) {
                    continue;
                }
                int freq = numberMap.get(num);
                numberMap.put(num, freq - 1);
                freqMap.put(freq, freqMap.get(freq) - 1);
                freqMap.put(freq - 1, freqMap.getOrDefault(freq - 1, 0) + 1);
            } else if (op == 3) {
                if (freqMap.getOrDefault(num, 0) > 0) {
                    result.add(1);
                } else {
                    result.add(0);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        bufferedWriter.write(
                ans.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
