import java.util.Scanner;

public class Baking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t0 = scanner.nextInt();
        int t1 = scanner.nextInt();
        int t2 = scanner.nextInt();
        int sum = Math.min(Math.abs(t0 - t1) + Math.abs(t1 - t2), Math.abs(t0 - t2) + Math.abs(t2 - t1));
        System.out.println(sum);
    }
}
