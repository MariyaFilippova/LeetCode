public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] nums = new int[n+m];
        while(i < m && j < n) {
            if (nums1[i] > nums2[j]) {
                nums[k] = nums2[j];
                j++;
            }
            else {
                nums[k] = nums1[i];
                i++;
            }
            k++;
        }
        while (i < m) {
            nums[k] = nums1[i];
            i++;
        }
        while (j < n) {
            nums[k] = nums1[j];
            j++;
        }
        for (int o = 0; o<n+m; o++) {
            nums1[o] = nums[o];
        }
    }
}
