 
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    private void dfs(TreeNode node, int remainingSum, List<Integer> currentPath, List<List<Integer>> result) {
        if (node == null) {
            return;
        }

         currentPath.add(node.val);

         if (node.left == null && node.right == null && node.val == remainingSum) {
            result.add(new ArrayList<>(currentPath));
        } else {
             dfs(node.left, remainingSum - node.val, currentPath, result);
            dfs(node.right, remainingSum - node.val, currentPath, result);
        }

        
        currentPath.remove(currentPath.size() - 1);
    }
}
