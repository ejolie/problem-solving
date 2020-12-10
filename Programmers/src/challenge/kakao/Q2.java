package challenge.kakao;

import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        String[] orders1 = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course1 = {2, 3, 4};

        String[] orders2 = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course2 = {2, 3, 5};

        String[] orders3 = {"XYZ", "XWY", "WXA"};
        int[] course3 = {2, 3, 4};

        System.out.println(Arrays.toString(solution(orders1, course1)));
        System.out.println(Arrays.toString(solution(orders2, course2)));
        System.out.println(Arrays.toString(solution(orders3, course3)));
    }

    public static String[] solution(String[] orders, int[] course) {
        Set<Integer> frequentMenus = new HashSet<>();
        for (int len : course) {
            Map<Integer, Integer> map = new HashMap<>();
            for (String order : orders) {
                combination(map, order.toCharArray(), new StringBuilder(), 0, len);
            }

            int maxCount = 2;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > maxCount) {
                    maxCount = entry.getValue();
                }
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == maxCount) {
                    frequentMenus.add(entry.getKey());
                }
            }
        }

        String[] answer = new String[frequentMenus.size()];
        int idx = 0;
        for (int bit : frequentMenus) {
            String menu = convertToString(bit);
            answer[idx++] = menu;
        }
        Arrays.sort(answer);
        return answer;
    }

    private static String convertToString(int bit) {
        String str = "";
        int mask = 1;
        for (int i = 0; i < 26; i++) {
            int shift = mask << i;
            if ((bit & shift) != 0) {
                char ch = (char) ('A' + i);
                str += ch;
            }
        }
        return str;
    }

    private static void combination(Map<Integer, Integer> map, char[] order, StringBuilder sb,
                                    int start, int len) {
        if (sb.length() == len) {
            int mask = 1 << 26;
            for (int i = 0; i < sb.length(); i++) {
                char ch = sb.charAt(i);
                int shift = 1 << (ch - 'A');
                mask |= shift;
            }
            int cnt = map.getOrDefault(mask, 0);
            map.put(mask, cnt + 1);
        } else {
            for (int i = start; i < order.length; i++) {
                sb.append(order[i]);
                combination(map, order, sb, i + 1, len);
                sb.delete(sb.length() - 1, sb.length());
            }
        }
    }
}
