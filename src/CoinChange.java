import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount <= 0) {
            return 0;
        }
        if (coins.length == 0) {
            return 0;
        }
        Arrays.sort(coins);
        int[] d = new int[amount + 1];

        Arrays.fill(d, Integer.MAX_VALUE);
        d[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int k = 0; k < coins.length; k++) {
                if (i - coins[k] >=0 && d[i - coins[k]] != Integer.MAX_VALUE) {
                    d[i] = Math.min(d[i], d[i - coins[k]] + 1);
                }
            }
        }
        return d[amount] == Integer.MAX_VALUE ? -1 : d[amount];
    }
}
