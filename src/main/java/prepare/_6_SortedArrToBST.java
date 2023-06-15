package prepare;

public class _6_SortedArrToBST {

    /**
     * 7.	https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/. Should run in O(N)
     */


    static class TreeNode {
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


    public TreeNode helper(int left, int right, int[] nums) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(left, mid - 1, nums);
        node.right = helper(mid + 1, right, nums);
        return node;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(0, nums.length - 1, nums);
    }
}
