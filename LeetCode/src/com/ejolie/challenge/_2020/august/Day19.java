package com.ejolie.challenge._2020.august;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Day19. Goat Latin
 */
public class Day19 {
    public static void main(String[] args) {
        String S = "I speak Goat Latin";
        System.out.println(toGoatLatin(S));
    }

    public static String toGoatLatin(String S) {
        String[] words = S.split(" ");
        String[] answer = new String[words.length];
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder();
            char firstChar = words[i].charAt(0);

            if (vowels.contains(Character.toLowerCase(firstChar))) {
                sb.append(words[i]);
            } else {
                sb.append(words[i].substring(1));
                sb.append(firstChar);
            }
            sb.append("ma");
            for (int j = 0; j <= i; j++) {
                sb.append("a");
            }

            answer[i] = sb.toString();
        }

        return String.join(" ", answer);
    }
}
