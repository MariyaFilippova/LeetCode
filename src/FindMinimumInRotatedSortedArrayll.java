public class FindMinimumInRotatedSortedArrayll {
    public int findMin(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        while (l < h) {
            int mid = l + (h - l)/2;
            if (nums[mid] > nums[h]) l = mid + 1;
            else if (nums[mid] < nums[h]) h = mid;
            else h--;
        }
        return nums[l];
    }
}
