public class PairsofSongsWithTotalDurationsDivisibleby60 {
    public int numPairsDivisibleBy60(int[] time) {
        int pairs = 0;
        if (time.length == 0) {
            return 0;
        }
        int[] res = new int[60];
        for (int i = 0; i < time.length; i++) {
            pairs += res[(60 - time[i] % 60) % 60];
            res[time[i] % 60]++;
        }
        return pairs;
    }
}
