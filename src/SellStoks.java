import java.util.Scanner;

class SellStoks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i<n; i++ ){
            prices[i] = scanner.nextInt();
        }
        new SellStoks().maxProfit(prices);
    }

    public int findFirstSmallest(int[] prices, int start) {
        while(start < prices.length - 1 && prices[start] <= prices[start + 1]) {
            start++;
        }
        return start;
    }


    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;
        int position = 0;
        for(;;) {
            position = findFirstSmallest(prices, position);
            if (position == n - 1) {
                return profit;
            }
            profit = profit - prices[position];
            while(position < n - 1 && prices[position] <= prices[position + 1]) {
                position++;
            }
            profit = profit + prices[position];
        }
    }
}
