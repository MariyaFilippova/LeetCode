public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int[] exchange = new int[3]; //5, 10, 20
        for (int bill: bills) {
            switch (bill) {
                case 5:
                    exchange[0]++;
                    break;
                case 10:
                    if (exchange[0] > 0) {
                        exchange[0]--;
                        exchange[1]++;
                    } else {
                        return false;
                    }
                    break;
                case 20:
                    if (exchange[0] > 0 && exchange[1] > 0) {
                        exchange[0]--;
                        exchange[1]--;
                    } else if (exchange[0] > 2) {
                        exchange[0] -= 3;
                    } else {
                        return false;
                    }
            }
        }
        return true;
    }
}
