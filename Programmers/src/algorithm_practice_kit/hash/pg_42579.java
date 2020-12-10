package algorithm_practice_kit.hash;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * 베스트앨범
 */
public class pg_42579 {
    public static void main(String[] args) {
        String[] genres1 = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays1 = {500, 600, 150, 800, 2500};

        String[] genres2 = {"classic", "classic", "classic", "classic", "pop"};
        int[] plays2 = {500, 150, 800, 800, 2500};

        assertArrayEquals(new int[]{4, 1, 3, 0}, solution(genres1, plays1));
        assertArrayEquals(new int[]{4, 2, 3}, solution(genres2, plays2));
    }

    // 노래 - 고유 번호로 구분
    // 노래 수록 기준
    // 1. 속한 노래가 많이 재생된 장르
    // 2. 장르 내에서 많이 재생된 노래
    // 3. 장르 내에서 재생횟수 같으면, 고유 번호 낮은 노래가 먼저 수록
    // 장르별로 두 개씩 선정
    public static int[] solution(String[] genres, int[] plays) {
        int N = genres.length;
        Map<String, TreeSet<Music>> musicInfo = new HashMap<>();
        Map<String, Integer> genreInfo = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int totalPlay = genreInfo.getOrDefault(genres[i], 0);
            totalPlay += plays[i];
            genreInfo.put(genres[i], totalPlay);

            TreeSet<Music> musics = musicInfo.getOrDefault(genres[i], new TreeSet<>((o1, o2) -> o1.play <= o2.play ? 1 : -1));
            musics.add(new Music(i, plays[i]));
            musicInfo.put(genres[i], musics);
        }

        Stream<Map.Entry<String, Integer>> sortedGenreInfo = genreInfo.entrySet()
                .stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()));
        List<Integer> result = new LinkedList<>();
        sortedGenreInfo.forEach(entry -> {
            TreeSet<Music> musics = musicInfo.get(entry.getKey());
            if (!musics.isEmpty()) {
                result.add(musics.pollFirst().num);
                if (!musics.isEmpty()) {
                    result.add(musics.pollFirst().num);
                }
            }
        });

        return result.stream().mapToInt(i -> i).toArray();
    }

    static class Music {
        int num;
        int play;

        public Music(int num, int play) {
            this.num = num;
            this.play = play;
        }
    }
}
