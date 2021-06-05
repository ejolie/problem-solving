package interview_preparation_kit.dictionaries_and_hashmaps.sherlock_and_anagrams;

import java.io.*;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'sherlockAndAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int sherlockAndAnagrams(String s) {
        int n = s.length();
        int anagrams = 0;

        for (int m = 1; m <= n - 1; m++) {
            for (int start = 0; start <= n - m; start++) {
                String s1 = s.substring(start, start + m);
                int[] counter1 = getAlphabetCounter(s1);

                for (int i = start + 1; i <= n - m; i++) {
                    String s2 = s.substring(i, i + m);
                    int[] counter2 = getAlphabetCounter(s2);

                    int j = 0;
                    for (; j < 26; j++) {
                        if (counter1[j] != counter2[j]) {
                            break;
                        }
                    }
                    if (j == 26) {
                        anagrams++;
                    }
                }
            }
        }

        return anagrams;
    }

    private static int[] getAlphabetCounter(String s) {
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
        }
        return counter;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.sherlockAndAnagrams(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

