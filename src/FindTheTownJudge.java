public class FindTheTownJudge {
    public int findJudge(int N, int[][] trust) {
        int[] counter = new int[N];
        int n = trust.length;
        for (int i = 0; i < n; i++) {
            int a = trust[i][0];
            int b = trust[i][1];
            counter[b - 1]++;
            counter[a - 1]--;
        }
        int judge = -1;
        for (int i = 0; i < N-1; i++){
            if (counter[i] == -N) {
                judge = i+1;
            }
        }
        return judge;
    }
}
