public class BeautifulArrangement {
    int counter = 0;

    public int countArrangement(int n) {
        backtrack(n, new int[n + 1], 1);
        return counter;
    }

    void backtrack(int n, int[] used, int place) {
        if (place > n) {
            counter++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (used[i] == 0 && (place % i == 0 || i % place == 0)) {
                used[i] = 1;
                backtrack(n, used, place + 1);
                used[i] = 0;
            }
        }
    }
}
