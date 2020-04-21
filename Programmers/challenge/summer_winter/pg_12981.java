package challenge.summer_winter;
import java.util.*;

/**
 * 영어 끝말잇기
 */
public class pg_12981 {
    public static void main(String[] args) {
        int n = 3;
        String[] words = {
            "tank", "kick", "know", 
            "wheel", "land", "dream",
            "mother", "robot", "tank"
        };
        System.out.println(Arrays.toString(solution(n, words)));
    }

    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();

        String curr = words[0];
        String prev = "";
        set.add(curr);
        for (int i = 1; i < words.length; i++) {
            prev = curr;
            curr = words[i];
            if (!valid(curr, prev, set)) {
                answer = new int[]{(i % n) + 1, (i / n) + 1};
                break;
            }
            set.add(curr);
        }

        return answer;
    }

    private static boolean valid(String curr, String prev, Set<String> set) {
        if (curr.length() <= 1) return false;
        if (prev.charAt(prev.length() - 1) != curr.charAt(0)) return false;
        if (set.contains(curr)) return false;
        return true; 
    }
}