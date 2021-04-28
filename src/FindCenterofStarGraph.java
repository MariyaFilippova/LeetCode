public class FindCenterofStarGraph {
    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        int [] freq = new int[n];
        for (int[] e: edges) {
            freq[e[0] - 1]++;
            freq[e[1] - 1]++;
        }
        int i = 0;
        for (int j = 0; j < freq.length; j++) {
            if (freq[j] == n - 1) {
                return j + 1;
            }
        }
        return i;
    }
}
