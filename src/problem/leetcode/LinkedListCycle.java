package problem.leetcode;


//141
public class LinkedListCycle {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(slow != null && fast != null) {
            slow = slow.next;
            if(fast.next == null) return false;
            fast = fast.next.next;
            if(slow == fast) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        list.next.next.next.next.next = new ListNode(6);
        list.next.next.next.next.next.next = new ListNode(7);
        list.next.next.next.next.next.next.next = new ListNode(8);
        list.next.next.next.next.next.next.next.next = new ListNode(9);
        list.next.next.next.next.next.next.next.next.next = list.next;
        boolean flag = LinkedListCycle.hasCycle(list);
        System.out.println(flag);

    }
}


