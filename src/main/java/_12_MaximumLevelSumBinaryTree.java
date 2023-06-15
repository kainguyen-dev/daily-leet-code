import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class TreeNode {
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

public class _12_MaximumLevelSumBinaryTree {


    public int maxLevelSum(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        int level = 0;

        queue.offer(root);

        while (!queue.isEmpty()) {
            levels.add(new ArrayList<>());
            int levelLen = queue.size();
            for (int i = 0; i < levelLen; i++) {

                TreeNode remove = queue.remove();
                levels.get(level).add(remove.val);

                if (remove.left != null) queue.add(remove.left);
                if (remove.right != null) queue.add(remove.right);
            }
            level++;
        }

        int max = Integer.MIN_VALUE;
        int resLevel = 0;

        for (int i = 0; i < levels.size(); i++) {
            int res = levels.get(i).stream().reduce(0, Integer::sum);
            if (res > max) {
                resLevel = i + 1;
                max = res;
            }
        }

        return resLevel;
    }

}
