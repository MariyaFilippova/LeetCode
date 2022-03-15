public class PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0;
        int h = arr.length - 1;
        while (l < h) {
            int mid = l + (h - l)/2;
            if (mid != arr.length - 1 && arr[mid] < arr[mid + 1]) l = mid + 1;
            else h = mid;
        }
        return l;
    }
}
