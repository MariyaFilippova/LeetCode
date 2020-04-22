import java.util.*;

public class CustomQueue {

    public int getEmptyCells(int[][] newPeople, int before) {
        int counter = 0;
        for (int i = 0; i< before; i++) {
            if (newPeople[i][0] == -1) {
                counter++;
            }
        }
        return counter;
    }

    public int getGreater(int[][] newPeople, int h, int before) {
        int counter = 0;
        for (int i = 0; i < before; i++) {
            if (newPeople[i][0] >= h) {
                counter++;
            }
        }
        return counter;
    }

    public int[][] reconstructQueue(int[][] people) {
        int number = people.length;
        int[][] newPeople = new int[people.length][2];
        for ( int i  = 0; i < number; i++) {
            newPeople[i][0] = -1;
        }
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (b[0] == a[0]) return a[1] - b[1];
                return b[0] - a[0];
            }
        });
        for (int i = number - 1; i >= 0; i--) {
            int before = people[i][1];
            int height = people[i][0];
            int position = before;
            int cells = getEmptyCells(newPeople, position);
            int greater = getGreater(newPeople, height, position);
            while (cells + greater != before) {
                    position++;
                    cells = getEmptyCells(newPeople, position);
                    greater = getGreater(newPeople, height, position);
            }
            while (newPeople[position][0] != -1) {
                position++;
            }
            newPeople[position] = people[i];
        }
        return newPeople;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] people = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                people[i][j] = scanner.nextInt();
            }
        }
        new CustomQueue().reconstructQueue(people);
    }
}
