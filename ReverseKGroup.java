
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        // Count total nodes
        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }

         ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        while (count >= k) {
            ListNode curr = prevGroupEnd.next;
            ListNode next = curr.next;

             for (int i = 1; i < k; i++) {
                curr.next = next.next;
                next.next = prevGroupEnd.next;
                prevGroupEnd.next = next;
                next = curr.next;
            }

            prevGroupEnd = curr;
            count -= k;
        }

        return dummy.next;
    }
}
