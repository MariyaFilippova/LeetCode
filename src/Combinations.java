import java.util.ArrayList;
import java.util.List;

public class Combinations {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, k, new ArrayList<>(), 1);
        return res;
    }

    void backtrack(int n, int k, List<Integer> list, int start) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            if (list.size() != 0 && list.get(list.size() - 1) > i) {
                continue;
            }
            list.add(i);
            backtrack(n, k, list, start + 1);
            list.remove(list.size() - 1);
        }
    }
}
