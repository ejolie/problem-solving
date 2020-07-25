package hash;

import java.util.Arrays;

/**
 * 전화번호 목록
 */
public class pg_42577 {
    public static void main(String[] args) {
        String[] phone_book = {
            "119",
            "97674223",
            "1195524421"
        };
        System.out.println(solution(phone_book));
    }

    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        String prev = phone_book[0];
        for (int i = 1; i < phone_book.length; i++) {
            if (phone_book[i].startsWith(prev)) {
                return false;
            }
            prev = phone_book[i];
        }
        return true;
    }
}
