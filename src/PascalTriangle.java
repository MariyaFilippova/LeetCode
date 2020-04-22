import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            if (i == 0) {
                res.add(new ArrayList<>(i+1));
                res.get(0).add(1);
                continue;
            }
            if (i == 1) {
                res.add(new ArrayList<>(i+1));
                res.get(1).add(1);
                res.get(1).add(1);
                continue;
            }
            res.add(new ArrayList<>(i+1));
            res.get(i).add(1);
            for (int j = 0; j + 1 < i; j++) {
                res.get(i).add(res.get(i - 1).get(j) + res.get(i - 1).get(j + 1));
            }
            res.get(i).add(1);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        new PascalTriangle().generate(n);
    }
}
