import java.util.*;

public class KthLargestElementInArray {

    int randomizedPartition(int[] a, int p, int r) {
        int i = (int) (Math.random() *(r - p)) + p;
        int c = a[r];
        a[r] = a[i];
        a[i] = c;
        return partition(a, p, r);
    }

    void randomizedQSort(int[] a, int l, int r) {
        if (l < r) {
            int q = randomizedPartition(a, l, r);
            randomizedQSort(a, l, q - 1);
            randomizedQSort(a, q + 1, r);
        }
    }

    int partition(int[] a, int l, int r) {
        int x = a[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (a[j] <= x) {
                i++;
                int c =  a[i];
                a[i] = a[j];
                a[j] = c;
            }
        }
        int position = i+ 1;
        int c = a[position];
        a[position] = a[r];
        a[r] = c;
        return position;
    }

    void quicksort(int[] a, int l, int r) {
        if (l < r) {
            int q = partition(a, l, r);
            quicksort(a, l, q - 1);
            quicksort(a, q + 1, r);
        }
    }

    int findKthLargest(int[] array, int k) {
        int l = 0;
        int r = array.length - 1;
        while(true) {
            int position = randomizedPartition(array, l, r);
            if (position < k) {
                l = position + 1;
            }
            else if (position > k) {
                r = position - 1;
            }
            else {
                return array[k];
            }
        }
    }

    public int badSolutionFindKthLargest(int[] nums, int k) {
        int number = 0;
        PriorityQueue<Integer> n = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            n.add(-nums[i]);
        }
        for (int i = 0; i < k; i++) {
            number = n.poll();
        }
        return -number;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        //int k = scanner.nextInt();
        long start = System.nanoTime();
        new KthLargestElementInArray().quicksort(nums, 0, nums.length - 1);
        long finish = System.nanoTime();
        System.out.println(finish - start);
        start = System.nanoTime();
        new KthLargestElementInArray().randomizedQSort(nums, 0, nums.length - 1);
        finish = System.nanoTime();
        System.out.println(finish - start);
    }
}
