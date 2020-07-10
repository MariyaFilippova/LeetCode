public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String pref = strs[0];
        int j = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(pref) != 0) {
                pref = pref.substring(0, j);
                j--;
            }
        }
        return pref;
    }
}
