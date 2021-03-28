public class CheckifNumberisaSumofPowersofThree {
    boolean flag;

    public boolean checkPowersOfThree(int n) {
        dfs(n, 16);
        return flag;
    }

    void dfs(int n, int power) {
        if (n == 0) {
            flag = true;
            return;
        }
        if (power < 0) {
            return;
        }
        if (n >= (int) Math.pow(3, power)) {
            n -= (int) Math.pow(3, power);
        }
        dfs(n, --power);
    }
}
