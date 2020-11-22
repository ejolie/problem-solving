package hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 전화번호 목록
 */
public class pg_42577 {
    public static void main(String[] args) {
        String[] phone_book = {"123", "456", "789"};
        System.out.println(solution_hash(phone_book));
    }

    public static boolean solution_sort(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return true;
    }

    public static boolean solution_hash(String[] phone_book) {
        Set<String> set = new HashSet<>();
        for (String phone : phone_book) {
            set.add(phone);
        }

        for (String phone : phone_book) {
            for (int i = 0; i < phone.length() - 1; i++) {
                String substr = phone.substring(0, i + 1);
                if (set.contains(substr)) {
                    return false;
                }
            }
        }

        return true;
    }
}
