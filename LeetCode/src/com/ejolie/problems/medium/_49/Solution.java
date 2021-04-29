package com.ejolie.problems.medium._49;

import java.util.*;

/**
 * 49. Group Anagrams
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] strs1 = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result1 = solution.groupAnagrams(strs1);

        String[] strs2 = new String[]{""};
        List<List<String>> result2 = solution.groupAnagrams(strs2);

        String[] strs3 = new String[]{"a"};
        List<List<String>> result3 = solution.groupAnagrams(strs3);

        String[] strs4 = new String[]{"ddddddddddg", "dgggggggggg"};
        List<List<String>> result4 = solution.groupAnagrams(strs4);
    }

    /**
     * Input
     * ["ddddddddddg","dgggggggggg"]
     * <p>
     * Output
     * [["ddddddddddg","dgggggggggg"]]
     * <p>
     * Expected
     * [["dgggggggggg"],["ddddddddddg"]]
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);

            String key = new String(chars);
            List<Integer> indices = map.getOrDefault(key, new ArrayList<>());
            indices.add(i);
            map.put(key, indices);
        }

        List<List<String>> answer = new ArrayList<>();
        for (List<Integer> indices : map.values()) {
            List<String> group = new ArrayList<>();
            for (int index : indices) {
                group.add(strs[index]);
            }
            answer.add(group);
        }
        return answer;
    }


}
