class ListNode {
    int val;
    ListNode next;
    
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class CheckPalindromeList {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Middle Node
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode curr = slow; // middle node
        ListNode prev = null;

        // Reversing second half
        while (curr != null) {
            ListNode nextN = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextN;
        }

        // Compare halves
        ListNode p1 = head;
        ListNode p2 = prev;

        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }

    // Main method to test the code
    public static void main(String[] args) {
        // Creating a sample palindrome linked list: 1 -> 2 -> 2 -> 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        CheckPalindromeList solution = new CheckPalindromeList();
        System.out.println("Is Palindrome: " + solution.isPalindrome(head));  // Output: true
    }
}
