public class FindtheMinimumNumberofFibonacciNumbersWhoseSumIsK {
    public int findMinFibonacciNumbers(int k) {
        int counter = 0;
        while (k > 1) {
            int i = 1;
            int j = 1;
            while (j + i <= k) {
                int p = i;
                i = j;
                j = j + p;
            }
            k = k - j;
            counter++;
        }
        return k == 0 ? counter : counter+ 1;
    }

    public static void main(String[] args) {
        new FindtheMinimumNumberofFibonacciNumbersWhoseSumIsK().findMinFibonacciNumbers(7);
    }
}
