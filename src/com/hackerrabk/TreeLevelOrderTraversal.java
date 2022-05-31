package com.hackerrabk;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/*
Tree: Level Order Traversal


* https://www.hackerrank.com/challenges/tree-level-order-traversal/problem
*

 This exercice cannot be resolved using recursion. recursion will act as a Stack and we should use the concept
 of Queue to solve this problem
 The idea is to run all lines before jump to next level of nodes. If we wanted to run all left or right nodes first,
 then we should ise
 recursion or Stack (similar to heightOfBinaryTree)
 */

public class TreeLevelOrderTraversal {


    public static void levelOrder(Node root) {
        if(root == null) {
            return;

        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node currentNode = queue.poll();
            System.out.printf("%d ", currentNode.data);

            if(currentNode.left !=null)
                queue.add(currentNode.left);
            if(currentNode.right !=null)
                queue.add(currentNode.right);
        }
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }
}
