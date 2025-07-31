 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public int rob(TreeNode root) {
        int[] result = robHelper(root);
        return Math.max(result[0], result[1]); 
    }

     private int[] robHelper(TreeNode node) {
        if (node == null) {
            return new int[2]; 
        }

        int[] left = robHelper(node.left);
        int[] right = robHelper(node.right);

        int[] res = new int[2];

         res[1] = node.val + left[0] + right[0];

         res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return res;
    }
}
