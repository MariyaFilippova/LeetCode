import java.util.Arrays;
import java.util.Scanner;

public class CheeseFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int sum = 0;
            int[] a = new int[3];
            int[] b = new int[3];
            for (int j = 0; j < 3; j++) {
                a[j] = scanner.nextInt();
            }
            for (int j = 0; j < 3; j++) {
                b[j] = scanner.nextInt();
            }
            Arrays.sort(a);
            Arrays.sort(b);
            for (int j = 0; j < 3; j++) {
                sum += a[j] * b[j];
            }
            System.out.println(sum);
        }

    }
}
