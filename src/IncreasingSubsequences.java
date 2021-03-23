import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequences {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtrack(nums, new ArrayList<>(), 0);
        return list;
    }

    void backtrack(int[] nums, List<Integer> subsequence, int start) {

        if (subsequence.size() >= 2) {
            list.add(new ArrayList<>(subsequence));
        }
        Set<Integer> used = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (used.contains(nums[i])) {
                continue;
            }
            if (subsequence.size() == 0 || subsequence.get(subsequence.size() - 1) <= nums[i]) {
                used.add(nums[i]);
                subsequence.add(nums[i]);
                backtrack(nums, subsequence, i + 1);
                subsequence.remove(subsequence.size() - 1);
            }
        }
    }
}
