package divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 쿼드 트리 (난이도: 하)
 * <p>
 * 1. 압축 문자열 분할하기 @decompress()
 * - 문제점: 입력 문자열 s의 나머지 부분을 넷으로 쪼개기가 까다롭다.
 * - 해결방법: s를 미리 쪼개는 것이 아니라 '필요한 만큼 가져다 쓰도록' 하자.
 * -> s를 통째로 전달하지 말고, s의 한 글자를 가리키는 포인터를 전달한다.
 * 함수 내에서는 한 글자를 검사할 때마다 포인터를 앞으로 한 칸씩 옮긴다.
 * <p>
 * 2. 압축 다 풀지 않고 뒤집기 @reverse()
 * - 문제점: 2^20x2^20 압축 해제하면 1TB라 너무 크다.
 * - 해결방법: 압축 해제 결과를 메모리에 저장하지 말고, 문자열 상태에서 이미지를 뒤집은 결과를 곧장 생성한다.
 * 1) 전체가 검은 색이거나 흰 색인 경우: 뒤집어도 그대로
 * 2) 전체가 한 가지 색이 아닌 경우: 네 등분을 각각 상하로 뒤집은 결과를 병합
 */
public class aoj_quadtree {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int cases = Integer.parseInt(br.readLine().trim());

        while (cases-- > 0) {
            String figure = br.readLine().trim();
            String answer = reverse(figure, 0);
            System.out.println(answer);
        }
    }

    /**
     * 문자열을 4등분하여 상하로 뒤집는다.
     *
     * @param figure
     * @param pos
     * @return
     */
    public static String reverse(String figure, int pos) {
        char firstChar = figure.charAt(pos);

        // base case: 전체가 검은 색이거나 흰 색인 경우 -> 뒤집어도 그대로
        if (firstChar == 'b' || firstChar == 'w') {
            return figure.substring(pos, pos + 1);
        }

        // recursive case: 전체가 한 가지 색이 아닌 경우 -> 네 등분을 각각 상하로 뒤집은 결과를 병합
        int delta = 1;
        String upperLeft = reverse(figure, pos + delta);
        delta += upperLeft.length();
        String upperRight = reverse(figure, pos + delta);
        delta += upperRight.length();
        String lowerLeft = reverse(figure, pos + delta);
        delta += lowerLeft.length();
        String lowerRight = reverse(figure, pos + delta);

        return "x" + lowerLeft + lowerRight + upperLeft + upperRight;
    }

}
