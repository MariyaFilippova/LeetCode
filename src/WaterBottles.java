public class WaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = 0;
        int empty = 0;
        int full = numBottles;
        do {
            res += full;
            empty = full + empty;
            full = empty / numExchange;
            empty = empty % numExchange;
        } while (full != 0 || empty / numExchange !=0 );
        return res;
    }

    public static void main(String[] args) {
        new WaterBottles().numWaterBottles(9, 3);
    }
}
