public class NumberOfSubstringsContainingAllThreeCharacters {
    public int numberOfSubstrings(String s) {
        int l = 0;
        int r = 0;
        int res = 0;
        int[] abc = new int[3];
        while (r >= l) {
            if (r == s.length() && !containAllChars(abc)) break;
            if (containAllChars(abc)) {
                res += s.length() - r + 1;
                abc[s.charAt(l++) - 'a']--;
                continue;
            }
            abc[s.charAt(r) - 'a']++;
            r++;
        }
        return res;
    }

    public static boolean containAllChars(int[] abc) {
        return abc[0] != 0 && abc[1] != 0 && abc[2] != 0;
    }
}
