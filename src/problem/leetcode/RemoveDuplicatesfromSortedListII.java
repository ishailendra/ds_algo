package problem.leetcode;

//82
public class RemoveDuplicatesfromSortedListII {

    //Definition for singly-linked list.
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {};
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        
        ListNode temp = head;
        ListNode prev = head;
        while(temp != null) {
            if(temp.val != temp.next.val) {
                temp = temp.next;
                prev = temp;
            }
        }

        return null;
    }
}
