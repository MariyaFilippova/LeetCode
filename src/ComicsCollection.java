import java.util.Scanner;

public class ComicsCollection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int cost = 0;
        for (int i = 0; i < n; i++) {
            int number = scanner.nextInt();
            int divByFive = number / 5;
            int divByThree = number / 3 - number / 15;
            int divByTwo = number / 2 - number / 6 - number / 10 + number / 30;
            int divByOne = number - divByFive - divByThree - divByTwo;
            cost = divByFive * 5 + divByThree * 3 + divByTwo * 2 + divByOne;
            System.out.println(cost);
        }
    }
}
