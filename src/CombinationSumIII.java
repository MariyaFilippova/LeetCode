import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = new int[9];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        backtrack(nums, k, n, new ArrayList<>(), 0, 0);
        return res;
    }


    void backtrack(int[] nums, int k, int n, List<Integer> list, int sum, int start) {
        if (k == 0 && n == sum) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (k == 0) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(nums, k - 1, n, list, sum + nums[i], i+1);
            list.remove(list.size() - 1);
        }
    }
}
