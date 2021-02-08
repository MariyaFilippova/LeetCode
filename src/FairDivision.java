import java.util.Scanner;

public class FairDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i<n ;i++) {
            int amount = scanner.nextInt();
            if ((amount - 3) % 3 != 0 || (amount - 3) / 3 < 0) {
                System.out.println(-1);
                continue;
            }
            System.out.println(String.format("%d %d %d", (amount - 3)/3, (amount - 3)/3+1, (amount - 3)/3+2));
        }
    }
}
