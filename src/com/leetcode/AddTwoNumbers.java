package com.leetcode;

/*You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.*/


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AddTwoNumbers {




      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }



    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

          return null;
    }

    public static void main(String[] args) {
        AddTwoNumbers add = new AddTwoNumbers();

        List<Integer> l1 = Arrays.asList(1, 4, 3);
        List<Integer> l2 = Arrays.asList(5, 6, 4);

        LinkedNode linkedNode = new LinkedNode<ListNode>();




//        l1.forEach(integer -> {
//            if(integer)
//        });

//        add.addTwoNumbers()
    }

    private void addNodes(LinkedNode linkedNode, Integer firstInteger, Integer secondInteger) {
        if(linkedNode.getFirstNode().equals(null)){
            linkedNode.addLastNode(new ListNode(firstInteger, new ListNode()));

        }
        else {
            Object previusFirstNode = linkedNode.getFirstNode();
            linkedNode.addFirstNode(new ListNode(firstInteger));



        }

      }

}

