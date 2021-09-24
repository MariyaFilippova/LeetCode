import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumGeneticMutation {
    public static int minMutation(String start, String end, String[] bank) {
        HashSet<String> setBank = new HashSet(Arrays.asList(bank));
        if (setBank.isEmpty()) {
            return -1;
        }
        setBank.add(start);
        if (!setBank.contains(end)) return -1;
        HashSet<String> setGens = new HashSet<>(Arrays.asList("A", "C", "G", "T"));
        HashSet<String> seen = new HashSet<>();
        seen.add(start);
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                String candidate = queue.poll();
                if (candidate.equals(end)) {
                    return level;
                }
                if (setBank.contains(candidate)) {
                    for (String gen : setGens) {
                        for (int i = 0; i < 8; i++) {
                            String newString = new StringBuilder(candidate)
                                    .replace(i, i + 1, gen)
                                    .toString();
                            if (!seen.contains(newString)) {
                                queue.add(newString);
                                seen.add(newString);
                            }
                        }
                    }
                }
                size--;
            }
            level++;
        }
        return -1;
    }
}
