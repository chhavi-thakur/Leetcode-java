 
  public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

         ListNode dummy = new ListNode(0);
        dummy.next = head;

         ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

         ListNode current = prev.next;
        ListNode nextNode = null;
        for (int i = 0; i < right - left; i++) {
            nextNode = current.next;
            current.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;
        }

        return dummy.next;
    }
}
