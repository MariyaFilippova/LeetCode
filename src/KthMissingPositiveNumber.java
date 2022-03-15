public class KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        if (arr.length == 0) return 0;
        int l = 0;
        int h = arr.length;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (arr[mid] - 1 - mid < k) l = mid + 1;
            else h = mid;
        }
        return l + k;
    }
}
