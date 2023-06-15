package prepare;

public class _3_ValidBST {

    // https://leetcode.com/problems/validate-binary-search-tree/

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return preOrder(root, null, null);
    }

    public boolean preOrder(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if ((min != null && root.val <= min) || (max != null && root.val >= max)) return false;
        return preOrder(root.left, min, root.val) && preOrder(root.right, root.val, max);
    }

    private Integer prev;
    // In order solution
    public boolean inOrder(TreeNode root) {
        if (root == null) return true;

        // return inOrder(root.left);
        if (!inOrder(root.left)) return false;

        if (prev != null && root.val <= prev) return false;
        prev = root.val;
        return inOrder(root.right);
    }

}
