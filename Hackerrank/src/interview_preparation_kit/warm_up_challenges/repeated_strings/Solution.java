package interview_preparation_kit.warm_up_challenges.repeated_strings;

import java.io.*;

// 9 min
class Result {

    public static long repeatedString(String s, long n) {
        long count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                count++;
            }
        }

        long totalCount = count * (n / s.length());
        int m = (int) (n % s.length());
        for (int i = 0; i < m; i++) {
            if (s.charAt(i) == 'a') {
                totalCount++;
            }
        }

        return totalCount;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result.repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
