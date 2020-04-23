public class FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int index = binarySearch(target, 0, nums.length - 1, nums);
        if (index == -1) {
            return new int[] {-1, -1};
        }
        int start = index;
        int end = index;
        while (start > 0 && nums[start - 1] == target) {
            start--;
        }
        while (end < nums.length - 1 && nums[end + 1] == target) {
            end++;
        }
        return new int[] {start, end};

    }

    public int binarySearch(int num, int start, int end, int[] nums) {
        if (start <= end) {
            int mid = (start + end) / 2;
            if (num == nums[mid] ) {
                return mid;
            }
            if (num < nums[mid]) {
                return binarySearch(num, start, mid - 1, nums);
            }
            if (num > nums[mid]) {
                return binarySearch(num, mid + 1, end, nums);
            }
        }
        return -1;
    }
}
