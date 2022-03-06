package problem.leetcode;

//206
public class ReverseLinkedList {

 private static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    public ListNode reverseList(ListNode head) {
        ListNode forward;
        ListNode previous = null;
        ListNode current = head;

        while(current != null) {
            forward = current.next;
            current.next = previous;
            previous = current;
            current = forward;
        }
        return previous;
    }
}
