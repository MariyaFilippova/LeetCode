import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> array = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            }
            else if (nums1[i] > nums2[j]) {
                j++;
            }
            else {
                array.add(nums1[i]);
                i++; j++;
            }
        }
        int[] res = new int[array.size()];
        for (i = 0; i < array.size(); i++) {
            res[i] = array.get(i);
        }
        return res;
    }
}
