package problem.leetcode;

import java.util.LinkedList;

//2
public class AddTwoNumbers {

    //Definition for singly-linked list.
   private static class ListNode {
     int val;
     ListNode next;
     ListNode() {};
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       int num1 = 0, num2 = 0;
       int carry = 0;
       ListNode ln = new ListNode();
       ListNode temp = ln;
        while((l1 !=null || l2 !=null)) {
            if(l1 != null) {
                num1 = l1.val;
                l1 = l1.next;
            }
            else {
                num1 = 0;
            }

            if(l2 != null) {
                num2 = l2.val;
                l2 = l2.next;
            }
            else {
                num2 = 0;
            }

            int rem = (num1+num2+carry)%10;
            carry = (num1+num2+carry)/10;

            temp.next = new ListNode(rem);
            temp = temp.next;
        }
        if(carry>0) {
            while(carry>0) {
                int rem = carry%10;
                carry = carry/10;
                temp.next = new ListNode(rem);
                temp = temp.next;
            }
        }

        return ln.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(9);
//        list1.next = new ListNode(4);
//        list1.next.next = new ListNode(3);
//[9]
//[1,9,9,9,9,9,9,9,9,9]
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(9);
        list2.next.next = new ListNode(9);
        list2.next.next.next = new ListNode(9);
        list2.next.next.next.next = new ListNode(9);
        list2.next.next.next.next.next = new ListNode(9);
        list2.next.next.next.next.next.next = new ListNode(9);
        list2.next.next.next.next.next.next.next = new ListNode(9);
        list2.next.next.next.next.next.next.next.next = new ListNode(9);
        list2.next.next.next.next.next.next.next.next.next = new ListNode(9);
//        list2.next.next.next.next.next.next.next.next.next.next = new ListNode(9);



        addTwoNumbers(list1, list2);
    }

}
