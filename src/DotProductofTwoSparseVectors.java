class SparseVector {

    int[] nums;

    SparseVector(int[] nums) {
        this.nums = nums;
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int res = 0;
        for (int i = 0; i < vec.nums.length; i++) {
            res += vec.nums[i] * this.nums[i];
        }
        return res;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);