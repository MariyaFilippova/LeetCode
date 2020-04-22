import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FindKClosestElements {


    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        ArrayList<Integer> result = new ArrayList<>();
        int[] res = new int[k];
        int index = Arrays.binarySearch(arr, x);
        if (index == -1) {
            for (int i = 0; i < k; i++) {
                result.add(arr[i]);
            }
            return result;
        }
        if (index >= arr.length) {
            for (int i = arr.length - 1; i < arr.length - 1 - k ; i--) {
                result.add(arr[i]);
            }
            return result;
        }
        if (index < 0) {
            index = - index - 1;
            int i = Math.max(0, index - 1 - k);
            int j = Math.min(arr.length - 1, index + 1 + k);
            while (j - i + 1  < k) {
                int left = x - arr[i];
                int right = arr[j] - x;
                if (left < right && i > 0) {
                    j--;
                }
                else if (j < arr.length - 1){
                    i++;
                }
            }
            for (int o = i; o <= j ; o++) {
                result.add(arr[o]);
            }
            return result;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int num = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(new FindKClosestElements().findClosestElements(nums, k, num));
    }
}
