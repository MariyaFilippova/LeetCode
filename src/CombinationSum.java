import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    int target;
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.target = target;
        Arrays.sort(candidates);
        backtrack(candidates, 0, new ArrayList<>(), 0);
        return res;
    }

    void backtrack(int[] candidates, int sum, List<Integer> list, int start) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            sum += candidates[i];
            list.add(candidates[i]);
            backtrack(candidates, sum, list, i);
            sum -= list.get(list.size() - 1);
            list.remove(list.size() - 1);
        }
    }
}
