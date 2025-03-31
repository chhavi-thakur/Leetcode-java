// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;
    
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
    
    // Helper method to create a linked list from an array
    public static ListNode createList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    // Helper method to print a linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

// Solution class containing the swapPairs method
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        
        while (curr.next != null && curr.next.next != null) {
            ListNode first = curr.next;
            ListNode second = curr.next.next;
            curr.next = second;
            first.next = second.next;
            second.next = first;
            curr = curr.next.next;
        }
        
        return dummy.next;
    }
}

// Main class for testing
public class SwapNodesInPairs {
    public static void main(String[] args) {
        // Input: Linked list [1, 2, 3, 4, 5]
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = ListNode.createList(arr);

        System.out.println("Original List:");
        ListNode.printList(head);

        // Creating an instance of Solution class
        Solution sol = new Solution();
        ListNode swappedHead = sol.swapPairs(head);

        System.out.println("List after swapping pairs:");
        ListNode.printList(swappedHead);
    }
}
