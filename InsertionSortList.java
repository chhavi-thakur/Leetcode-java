// ------------  ListNode definition ------------
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

// ------------  Main class (file name must match) ------------
public class InsertionSortList {

    // -------- insertion-sort on linked list --------
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);      // dummy head of sorted sub-list
        ListNode curr  = head;                 // node to be inserted

        while (curr != null) {
            ListNode prev = dummy;             // start from dummy each round
            ListNode next = curr.next;         // store next node before re-linking

            // find the insertion spot
            while (prev.next != null && prev.next.val < curr.val)
                prev = prev.next;

            // insert curr between prev and prev.next
            curr.next = prev.next;
            prev.next = curr;

            curr = next;                       // move to original next node
        }
        return dummy.next;
    }

    // -------- helper to print list --------
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + (head.next != null ? " -> " : ""));
            head = head.next;
        }
        System.out.println();
    }

    // -------- test driver --------
    public static void main(String[] args) {
        /* Build example list: 4 -> 2 -> 1 -> 3 */
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        System.out.print("Original list: ");
        printList(head);

        InsertionSortList sorter = new InsertionSortList();
        ListNode sorted = sorter.insertionSortList(head);

        System.out.print("Sorted list:   ");
        printList(sorted);
    }
}
