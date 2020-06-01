import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, res, new ArrayList<>(), 0);
        return res;
    }

    void backtrack(int[] nums, List<List<Integer>> res, List<Integer> set, int start) {
        res.add(new ArrayList<>(set));
        for (int i = start; i < nums.length; i++) {
            set.add(nums[i]);
            backtrack(nums, res, set, i + 1);
            set.remove(set.size() - 1);
        }
    }

    public static void main(String[] args) {
        new Subsets().subsets(new int[] {1,2,3});
    }
}
