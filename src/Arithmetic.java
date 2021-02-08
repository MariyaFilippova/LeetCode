import java.util.Scanner;

public class Arithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            if ( a * b == c ) {
                System.out.println("YES");
                System.out.println(String.format("%d %d %d", a, b, c));
                continue;
            }
            if ( b * c == a ) {
                System.out.println("YES");
                System.out.println(String.format("%d %d %d", b, c, a));
                continue;
            }
            if ( c * a == b ) {
                System.out.println("YES");
                System.out.println(String.format("%d %d %d", a, c, b));
                continue;
            }
            System.out.println("NO");

        }
    }
}
