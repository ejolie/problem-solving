package algorithm_practice_kit.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 완주하지 못한 선수
 */
public class pg_42576 {

    public static void main(String[] args) {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "nikola", "vinko"};
        System.out.println(solution_sort(participant, completion));
    }

    public static String solution_sort(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i = 0; i < completion.length; i++) {
            if (!completion[i].equals(participant[i])) {
                return participant[i];
            }
        }

        return participant[participant.length - 1];
    }

    public static String solution_hash(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        for (String p : participant) {
            int count = map.getOrDefault(p, 0);
            map.put(p, count + 1);
        }

        for (String c : completion) {
            int count = map.get(c);
            map.put(c, count - 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                return entry.getKey();
            }
        }

        return "";
    }
}
