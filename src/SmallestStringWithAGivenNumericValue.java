import java.util.Arrays;

public class SmallestStringWithAGivenNumericValue {
    public String getSmallestString(int n, int k) {
        char[] ca = new char[n];
        Arrays.fill(ca, 'a');
        k -= n;
        for (int i = n - 1; i >= 0 && k > 0; --i) {
            ca[i] += Math.min(25, k);
            k -= Math.min(k, 25);
        }
        return String.valueOf(ca);
    }
}
