public class NumberofGoodWaystoSplitaString {
    public int numSplits(String s) {
        if (s.length() <= 2) {
            return s.length() - 1;
        }
        int counter = 0;
        String reversed = new StringBuilder(s).reverse().toString();
        int[] distinct = new int[s.length() - 1];
        int[] letters = new int[26];
        int[] distinct2 = new int[s.length() - 1];
        int[] letters2 = new int[26];
        distinct[0] = 1;
        distinct2[0] = 1;
        letters[s.charAt(0) - 'a']++;
        letters2[reversed.charAt(0) - 'a']++;
        for (int i = 1; i < distinct.length; i++) {
            int c = s.charAt(i) - 'a';
            int q = reversed.charAt(i) - 'a';
            if (letters[c] == 0) {
                distinct[i] = distinct[i - 1] + 1;
                letters[c] ++;
            }
            else {
                distinct[i] = distinct[i - 1];
            }
            if (letters2[q] == 0) {
                letters2[q]++;
                distinct2[i] = distinct2[i - 1] + 1;
            }
            else {
                distinct2[i] = distinct2[i - 1];
            }
        }
        for (int i = 0; i < distinct.length; i++) {
            if (distinct[i] == distinct2[distinct.length - 1 - i]) {
                counter++;
            }
        }
        return counter;
    }
}
