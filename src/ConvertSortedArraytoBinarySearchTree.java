public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        Tree tree = new Tree();
        insertion(tree, 0, nums.length, nums);
        return tree.root;
    }
    public void insertion(Tree tree, int start, int end, int[] nums) {
        if (start > end) {
            return;
        }
        int mid = (start+end)/2;
        tree.insert(nums[mid]);
        insertion(tree, start, mid - 1, nums);
        insertion(tree, mid + 1, end, nums);
    }
}
