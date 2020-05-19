public class MaximumBinaryTree {


    public int max(int start, int end, int[] nums) {
        int max = 0;
        int index = start;
        for (int i = start; i < end; i++) {
            if (max < nums[i]){
                max = nums[i];
                index = i;
            }

        }
        return index;
    }

    public TreeNode insertion( int start, int end, int[] nums) {
        if (start == end) {
            return null;
        }
        int index = max(start, end, nums);
        TreeNode root = new TreeNode(nums[index]);
        root.left = insertion(start, index, nums);
        root.right = insertion(index + 1, end, nums);
        return root;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return insertion(0, nums.length, nums);
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        new MaximumBinaryTree().constructMaximumBinaryTree(nums);
    }
}
