import java.util.Scanner;

public class SortColors {
    public void sortColors(int[] nums) {
        int d[] = new int[3];
        for (int i = 0; i < nums.length; i++) {
            d[nums[i]]++;
        }
        int j = 0;
        int i = 0;
        while(i < nums.length) {
            while (j < 3 && d[j] > 0) {
                nums[i] = j;
                i++;
                d[j]--;
            }
            j++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        new SortColors().sortColors(nums);
    }
}
