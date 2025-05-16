 
public class Solution {
    private int postIndex;
    private HashMap<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        inorderIndexMap = new HashMap<>();
        
         for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        
        return buildSubTree(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode buildSubTree(int[] inorder, int[] postorder, int inLeft, int inRight) {
        if (inLeft > inRight) {
            return null;
        }
        
         int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);
        
         int inorderIndex = inorderIndexMap.get(rootVal);
        
         root.right = buildSubTree(inorder, postorder, inorderIndex + 1, inRight);
        root.left = buildSubTree(inorder, postorder, inLeft, inorderIndex - 1);
        
        return root;
    }
}
B
