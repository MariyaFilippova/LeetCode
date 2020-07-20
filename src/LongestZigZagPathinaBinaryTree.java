public class LongestZigZagPathinaBinaryTree {
    public int longestZigZag(TreeNode root) {
        int [] res = longestPath(root);
        return Math.max(Math.max(res[0], res[1]), res[2]);
    }

    int [] longestPath(TreeNode root) {
        if (root == null) {
            return new int[] {0, 0, 0};
        }
        int [] left = longestPath(root.left);
        int [] right = longestPath(root.right);
        int [] res = new int[3];
        res[0] = left[1] + 1;
        res[1] = right[0] + 1;
        res[2] = Math.max( Math.max(res[0], res[1]),  Math.max(left[2], right[2]));
        return res;
    }
}
