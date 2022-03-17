public class ReverseWordsinaStringIII {
    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (String string : strings) {
            char[] a = string.toCharArray();
            int i = 0;
            int j = a.length - 1;
            while (i < j) {
                char c = a[i];
                a[i] = a[j];
                a[j] = c;
                i++;
                j--;
            }
            builder.append(a).append(" ");
        }
        return builder.deleteCharAt(builder.length() - 1).toString();
    }

}
