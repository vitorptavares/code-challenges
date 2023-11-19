package br.leetcode.medium;

/*You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.*/


public class AddTwoNumbers {


      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

//    static class Solution {
//        public  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//
//            ListNode head = new ListNode(0, new ListNode());
//            ListNode dummyNode = head;
//            int carry = 0;
//            int sum = 0;
//
//            while (l1!=null && l2!=null){
//
//                if(l1 !=null){
//                    sum = l1.val  + sum;
//                    l1 = l1.next;
//                }
//
//                if(l2 !=null){
//                    sum = l2.val + sum;
//                    l2 = l2.next;
//                }
//
//                sum = sum + carry;
//                carry = sum/10;
//                    dummyNode.next = new ListNode(sum%10);
//                    dummyNode = dummyNode.next;
//                }
//            return head.next;
//
//        }
//    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);

        l1.next = new ListNode(5);
        l2.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l2.next.next = new ListNode(6);
        l1.next.next.next = new ListNode(3);
        l2.next.next.next = new ListNode(4);

        Solution solution = new Solution();
        solution.addTwoNumbers(l1,l2);

    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(0);
            ListNode node = head;

            int carry = 0;
            int sum = 0;

            while (l1 !=null || l2 !=null || carry!=0){
                sum = 0;
                if(l1!=null){
                    sum = sum + l1.val ;
                    l1 = l1.next;
                }
                if(l2!=null){
                    sum = sum + l2.val ;
                    l2 = l2.next;
                }
                sum = sum + carry;
                carry = sum/10;




                node.next = new ListNode(sum%10);
                node = node.next;
            }
            return head.next;
        }
    }


}

