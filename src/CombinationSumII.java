import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, new ArrayList<>(), 0, 0);
        return res;
    }

    void backtrack(int[] candidates, int target, List<Integer> list, int sum, int start) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            sum += candidates[i];
            list.add(candidates[i]);
            backtrack(candidates, target, list, sum, i + 1);
            sum -= list.get(list.size() - 1);
            list.remove(list.size() - 1);
        }
    }
}
