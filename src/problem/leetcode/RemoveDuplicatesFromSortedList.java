package problem.leetcode;

public class RemoveDuplicatesFromSortedList {

    private static class ListNode {
         int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;

        while(temp.next != null) {
            if(temp.val == temp.next.val) {
                temp.next = temp.next.next;
            }else {
                temp = temp.next;
            }
        }

        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {

        if (head == null) {
            return head;
        }
        ListNode current = head;
        ListNode temp = current.next;

        while (temp !=  null) {
            if (temp.val != current.val) {
                current.next = temp;
                current = temp;
            }
            temp = temp.next ;
        }
        current.next = temp;
        return head;
    }


}
