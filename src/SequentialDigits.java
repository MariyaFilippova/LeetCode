import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {
    List<Integer> res = new ArrayList<>();
    public List<Integer> sequentialDigits(int low, int high) {
        if (low > high) {
            return res;
        }
        for (int i = 1; i <= 9; i++) {
            int s = res.size();
            backtrack(new StringBuilder(), low, high, i);
        }
        res.sort((a, b) -> a - b);
        return res;
    }

    void backtrack(StringBuilder s, int low, int high, int start) {
        int num = s.length() == 0 ? 0 : Integer.valueOf(s.toString()) ;
        if (num > high) {
            return;
        }
        if (num >= low && num <= high) {
            res.add(num);
        }
        if (start >= 10) {
            return;
        }
        s.append(start);
        backtrack(s, low, high, start + 1);
        s.deleteCharAt(s.length() - 1);
    }
}
