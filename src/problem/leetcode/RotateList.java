package problem.leetcode;

//61
public class RotateList {

    //Definition for singly-linked list.
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {};
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode rotateRight(ListNode head, int k) {

        if(head == null) return head;
        int size = 0;
        ListNode temp = head;
        while(temp  != null) {
            size++;
            temp = temp.next;
        }

        k = k%size;
        if(k == 0) return head;
        int counter = 0;
        temp = head;
        ListNode next = null;
        while(counter != (size-k)) {
            counter++;
            if(counter == (size-k)) {
                next = temp.next;
                temp.next = null;
            }
            temp = temp.next;
        }

        temp = next;
        while(temp.next != null) {
            temp = temp.next;
        }

        temp.next = head;
        return next;

    }

    public static void main(String[] args) {
        ListNode list2 = new ListNode(1);
//        list2.next = new ListNode(2);
//        list2.next.next = new ListNode(3);
//        list2.next.next.next = new ListNode(4);
//        list2.next.next.next.next = new ListNode(5);
//        list2.next.next.next.next.next = new ListNode(9);
//        list2.next.next.next.next.next.next = new ListNode(9);
//        list2.next.next.next.next.next.next.next = new ListNode(9);
//        list2.next.next.next.next.next.next.next.next = new ListNode(9);
//        list2.next.next.next.next.next.next.next.next.next = new ListNode(9);

        list2 = rotateRight(list2, 1);

        while(list2 != null) {
            System.out.print(list2.val + "  ");
            list2 = list2.next;
        }
    }
}
