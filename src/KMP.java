import java.util.*;

public class KMP {
    public static int[] prefixFunction(String s) {
        int[] prefixes = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            int j = prefixes[i - 1];
            while( j > 0 && s.charAt(i) != s.charAt(j)) {
                j = prefixes[j - 1];
            }
            if (s.charAt(j) == s.charAt(i)) {
                j++;
            }
            prefixes[i] = j;
        }
        return prefixes;
    }

    public static ArrayList<Integer> getOccur(String s, String pattern) {
        int [] pref = prefixFunction(pattern+"@"+s);
        ArrayList<Integer> occ = new ArrayList<>();
        for (int i = 0; i < pref.length; i++) {
            if (pref[i] == pattern.length()) {
                occ.add(i - 2*pattern.length());
            }
        }
        return occ;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String pattern = scanner.next();
        List<Integer> res = KMP.getOccur(s, pattern);
        for ( int i: res) {
            System.out.println(i);
        }
    }
}
