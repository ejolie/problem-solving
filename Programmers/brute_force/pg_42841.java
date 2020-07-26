package brute_force;

import java.util.*;

/**
 * 숫자 야구
 */
public class pg_42841 {
    public static void main(String[] args) {
        int[][] baseball = {
            {123, 1, 1},
            {356, 1, 0},
            {327, 2, 0},
            {489, 0, 1}
        };
        System.out.println(solution(baseball));
    }

    public static int solution(int[][] baseball) {
        List<String> list = new LinkedList<>();

        for (int n = 123; n <= 987; n++) {
            String s = String.valueOf(n);

            if (s.charAt(0) == s.charAt(1) || s.charAt(1) == s.charAt(2) || s.charAt(2) == s.charAt(0)) continue;
            if (s.charAt(0) == '0' || s.charAt(1) == '0' || s.charAt(2) == '0') continue;

            list.add(s);
        }

        for (int[] info : baseball) {
            String a = String.valueOf(info[0]);
            Iterator<String> it = list.iterator();

            while (it.hasNext()) {
                int strike = 0;
                int ball = 0;
                String b = it.next();

                for (int j = 0; j < 3; j++) {
                    if (b.charAt(j) == a.charAt(j)) strike++;
                    else if (b.charAt((j + 1) % 3) == a.charAt(j) || b.charAt((j + 2) % 3) == a.charAt(j)) ball++;
                }

                if (strike != info[1] || ball != info[2]) {
                    it.remove();
                }
            }
        }

        return list.size();
    }
}
