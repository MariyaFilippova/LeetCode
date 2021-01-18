import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KCombinationsFromN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), n, k, 0);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.print("\n");
        }
    }

    static void backtrack(List<List<Integer>> list, ArrayList combination, int n, int k, int start) {
        if (combination.size() == k) {
            list.add(new ArrayList<Integer>(combination));
            return;
        }
        for (int i = start; i < n; i++) {
            combination.add(i);
            backtrack(list, combination, n, k, i + 1);
            combination.remove(combination.size() - 1);
        }
    }
}
