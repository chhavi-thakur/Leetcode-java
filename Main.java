import java.util.*;

// TreeNode definition
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

// Solution class with binaryTreePaths method
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(root, path, ans);
        return ans;
    }

    private void dfs(TreeNode node, List<String> path, List<String> ans) {
        if (node == null) return;

        path.add(Integer.toString(node.val));
        if (node.left == null && node.right == null) {
            ans.add(String.join("->", path));
        } else {
            dfs(node.left, path, ans);
            dfs(node.right, path, ans);
        }
        path.remove(path.size() - 1);
    }
}

// Main class to test the solution
public class Main {
    public static void main(String[] args) {
        // Constructing a sample binary tree:
        //      1
        //     / \
        //    2   3
        //     \
        //      5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);

        // Running the solution
        Solution sol = new Solution();
        List<String> paths = sol.binaryTreePaths(root);

        // Output the paths
        System.out.println("Binary Tree Paths:");
        for (String path : paths) {
            System.out.println(path);
        }
    }
}
