import java.util.Scanner;

public class Zeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int localMax = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (scanner.nextInt() == 1) {
                localMax++;
            }
            else {
                if ( max < localMax) {
                    max = localMax;
                }
                localMax = 0;
            }
        }
        if ( max < localMax) {
            max = localMax;
        }

        System.out.println(max);
    }
}
