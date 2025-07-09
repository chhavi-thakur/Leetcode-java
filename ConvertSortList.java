public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return buildBST(head, null);
    }

    private TreeNode buildBST(ListNode head, ListNode tail) {
        if (head == tail) return null;

         ListNode slow = head;
        ListNode fast = head;
        
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = buildBST(head, slow);
        root.right = buildBST(slow.next, tail);

        return root;
    }
}
