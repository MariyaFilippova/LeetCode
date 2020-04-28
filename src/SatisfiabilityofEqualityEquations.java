import java.util.Scanner;

public class SatisfiabilityofEqualityEquations {
    public boolean equationsPossible(String[] equations) {
        int[] eq = new int[26];
        for (int i = 0; i < 26; i++) {
            eq[i] = i;
        }
        for (String s : equations) {
            char a = s.charAt(0);
            char b = s.charAt(3);
            int u = find(eq, a - 'a');
            int v = find(eq, b - 'a');
            if (s.charAt(1) == '=') {
                eq[v] = u;
            }
        }
        for (String s : equations) {
            char a = s.charAt(0);
            char b = s.charAt(3);
            int u = find(eq, a - 'a');
            int v = find(eq, b - 'a');
            if (s.charAt(1) == '!') {
                if (u == v) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean union(int[] parents, int v, int u) {
        return !(find(parents, v) == find(parents, u));
    }

    public int find(int[] parents, int v) {
        if (v == parents[v]) {
            return v;
        }
        return find(parents, parents[v]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.next();
        }
        new SatisfiabilityofEqualityEquations().equationsPossible(strings);
    }
}
