public class CountPrimes {
    int counter = 0;

    public int countPrimes(int n) {
        if (n == 0) {
            return 0;
        }
        boolean [] prime = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            prime[i] = true;
        }
        prime[1] = false;
        int lim = n / 2;
        int k;
        for (int j = 2; j <= lim; j++) {
            k = j;
            while (j + k < n) {
                prime[j + k] = false;
                k = k + j;
            }
        }
        for (int i = 1; i < n; i++) {
            if (prime[i]) {
                counter++;
            }
        }
        return counter;
    }
}
