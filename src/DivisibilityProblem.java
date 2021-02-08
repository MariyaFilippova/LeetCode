import java.util.ArrayList;
import java.util.Scanner;

public class DivisibilityProblem {

    static ArrayList<Integer> list = new ArrayList<>();
    static boolean found = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int div = (int)Math.pow(2, n);
        backtrack(n, new StringBuilder(), div);
        if (!found) {
            System.out.println(-1);
        }
    }

    static void backtrack(int n, StringBuilder string, int div) {
        if (string.length() == n && Long.valueOf(string.toString()) % div == 0) {
            System.out.print(string);
            found = true;
            return;
        }
        if (string.length() == n) {
            return;
        }
        for (int i = 1; i <= 2; i++) {
            string.append(i);
            backtrack(n, string, div);
            string.deleteCharAt(string.length() - 1);
        }
    }
}
