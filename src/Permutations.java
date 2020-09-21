import java.util.ArrayList;
import java.util.List;

public class Permutations {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> permutation = new ArrayList<>();
        dfs(permutation, nums);
        return res;
    }

    void dfs(List<Integer> permutation, int[] nums) {
        if (permutation.size() == nums.length) {
            res.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (permutation.contains(nums[i])) {
                continue;
            }
            permutation.add(nums[i]);
            dfs(permutation, nums);
            permutation.remove(permutation.size() - 1);
        }
    }

    public static void main(String[] args) {
        new Permutations().permute(new int[]{1,2,3});
    }
}
