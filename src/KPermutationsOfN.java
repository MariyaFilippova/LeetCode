import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KPermutationsOfN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), k, n);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.print("\n");
        }
    }

    static void backtrack(List<List<Integer>> list, ArrayList<Integer> permutation, int k, int n) {
        if (permutation.size() == k) {
            list.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (permutation.contains(i)) {
                continue;
            }
            permutation.add(i);
            backtrack(list, permutation, k, n);
            permutation.remove(permutation.size() - 1);
        }
    }
}
