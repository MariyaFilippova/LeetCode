import java.util.ArrayList;
import java.util.List;

public class NumbersWithSameConsecutiveDifferences {
    List<Integer> list = new ArrayList<>();

    public int[] numsSameConsecDiff(int n, int k) {
        dfs(n, k, 0);
        int[] res = new int [list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    void dfs(int n, int k, int number) {
        if (n == 0) {
            list.add(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (number == 0 && i == 0) {
                continue;
            }
            else if (number == 0) {
                dfs(n - 1, k, i);
            }
            else {
                if(Math.abs((number%10) - i) == k){
                    dfs(n-1, k, number*10+i);    // General dfs to add the digit at the units place and reducing the number of digits by 1.
                }
            }
        }
    }
}
