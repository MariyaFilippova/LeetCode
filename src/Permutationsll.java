import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutationsll {
    List<List<Integer>> res = new ArrayList<>();
    boolean [] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtrack(nums, new ArrayList<>());
        return res;
    }

    void backtrack(int[] nums, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i != 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            used[i] = true;
            backtrack(nums, list);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        new Permutationsll().permuteUnique(new int[]{1,1,2});
    }
}
