public class HouseRobberIII {
    public int rob(TreeNode root) {
        int[] res = subRob(root);
        return Math.max(res[0], res[1]);
    }

    public int[] subRob(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        int[] left = subRob(root.left);
        int[] right = subRob(root.right);
        int[] res = new int[2];
        res[1] = root.val + left[0] + right[0];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }

}
