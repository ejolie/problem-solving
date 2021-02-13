package lesson1;

public class BinaryGap {
    public int solution(int N) {
        String binaryString = Integer.toBinaryString(N);
        int maxLength = 0;
        int startIndex = -1;

        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                if (startIndex != -1) {
                    maxLength = Math.max(maxLength, i - startIndex - 1);
                }
                startIndex = i;
            }
        }

        return maxLength;
    }
}