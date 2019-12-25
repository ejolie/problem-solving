package src.java.problems;

/*
 * 1282. Group the People Given the Group Size They Belong To (Medium)
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Q1282 {
    public static void main(String[] args) {
        int[] groupSizes = { 2, 2, 1, 1, 1, 1, 1, 1 };
        List<List<Integer>> res = groupThePeople(groupSizes);
    }

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> groupList = new ArrayList<>();
        Map<Integer, List<Integer>> groupMap = new HashMap<>();

        for (int id = 0; id < groupSizes.length; id++) {
            int size = groupSizes[id];
            if (!groupMap.containsKey(size)) {
                groupMap.put(size, new ArrayList<>());
            }
            groupMap.get(size).add(id);
        }

        for (Map.Entry<Integer, List<Integer>> entry : groupMap.entrySet()) {
            int size = entry.getKey();
            List<Integer> group = entry.getValue();

            if (size == group.size()) {
                groupList.add(group);
            } else {
                for (int i = 0; i < group.size(); i += size) {
                    List<Integer> subGroup = group.subList(i, i + size);
                    groupList.add(subGroup);
                }
            }
        }

        return groupList;
    }
}