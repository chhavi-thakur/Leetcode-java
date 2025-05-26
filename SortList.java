class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}

public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // Step 1. Cut the list to two halves
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        // Step 2. Sort each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // Step 3. Merge the sorted halves
        return merge(l1, l2);
    }

    ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if (l1 != null) tail.next = l1;
        if (l2 != null) tail.next = l2;
        return dummy.next;
    }

    // Helper method to print a linked list
    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Main method to test
    public static void main(String[] args) {
        SortList obj = new SortList();

        // Creating linked list: 4 -> 2 -> 1 -> 3
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        System.out.print("Original list: ");
        obj.printList(head);

        ListNode sortedHead = obj.sortList(head);

        System.out.print("Sorted list: ");
        obj.printList(sortedHead);
    }
}
