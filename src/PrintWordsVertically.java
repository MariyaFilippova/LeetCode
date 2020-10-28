import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintWordsVertically {
    public List<String> printVertically(String s) {
        String[] strings = s.split(" ");
        int max = Integer.MIN_VALUE;
        for (String string : strings) {
            max = Math.max(max, string.length());
        }
        List<StringBuilder> res = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            res.add(new StringBuilder());
            for (String string : strings) {
                if (i < string.length()) {
                    res.get(res.size() - 1).append(string.charAt(i));
                }
                else {
                    res.get(res.size() - 1).append(" ");
                }
            }
        }
        List<String> result = new ArrayList<>();
        for ( StringBuilder stringBuilder: res) {
            result.add(stringBuilder.toString().replaceAll("\\s+$", ""));
        }
        return result;
    }
}
