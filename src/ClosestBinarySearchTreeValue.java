/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        return dfs(root, target, root.val);
    }

    int dfs(TreeNode root, double target, int val) {
        if (root == null) {
            return val;
        }
        double diff = Math.abs(target - root.val);
        int left = dfs(root.left, target, root.val);
        int right = dfs(root.right, target, root.val);
        if (Math.abs(left - target) < Math.abs(right - target) && Math.abs(left - target) < diff) {
            return left;
        }
        if (Math.abs(right - target) < Math.abs(left - target) && Math.abs(right - target) < diff) {
            return right;
        }
        return root.val;
    }
}