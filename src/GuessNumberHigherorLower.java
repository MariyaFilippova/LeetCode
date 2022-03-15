public class GuessNumberHigherorLower {
    public int guessNumber(int n) {
        int l = 1;
        int h = n;
        while (l < h) {
            int mid = l + (h - l)/2;
            int guess = guess(mid);
            if (guess == 0) return mid;
            if (guess > 0) l = mid + 1;
            else h = mid - 1;
        }
        return l;
    }

    int guess(int num) {
        return 0;
    }
}
