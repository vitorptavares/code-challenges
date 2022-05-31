package com.hackerrabk.medium;


/*
* Exercise: https://www.hackerrank.com/challenges/one-week-preparation-kit-queue-using-two-stacks/problem?h_r=internal-search
* Resolution: https://www.youtube.com/watch?v=7ArHz8jPglw
*
*
A queue is an abstract data type that maintains the order in which elements were added to it, allowing the oldest

elements to be removed from the front and new elements to be added to the rear. This is called a First-In-First-Out
(FIFO) data structure because the first element added to the queue (i.e., the one that has been waiting the longest)
is always the first one to be removed.

A basic queue has the following operations:

Enqueue: add a new element to the end of the queue.
Dequeue: remove the element from the front of the queue and return it.
In this challenge, you must first implement a queue using two stacks. Then process  queries, where each query is
* one of the following  types:

1 x: Enqueue element  into the end of the queue.
2: Dequeue the element at the front of the queue.
3: Print the element at the front of the queue.
Input Format

The first line contains a single integer, , denoting the number of queries.
Each line  of the  subsequent lines contains a single query in the form described in the problem statement above.
* All three queries start with an integer denoting the query , but only query  is followed by an additional
* space-separated value, , denoting the value to be enqueued.

Constraints

It is guaranteed that a valid answer always exists for each query of type .
Output Format

For each query of type , print the value of the element at the front of the queue on a new line.

Sample Input

STDIN   Function
-----   --------
10      q = 10 (number of queries)
1 42    1st query, enqueue 42
2       dequeue front element
1 14    enqueue 42
3       print the front element
1 28    enqueue 28
3       print the front element
1 60    enqueue 60
1 78    enqueue 78
2       dequeue front element
2       dequeue front element
Sample Output

14
14

*
*
*
Explanation (Need open the exercise site)
*/

/*
* The ideia of this exercice is to have two stacks. Second stack (reversed) will maintain the queue order.
* When calling print and dequeue methods, we need reverse the order pulling from stack to reversedStack.
* This way, when printing reversedStack, it will pop the first element which is the last element of stack
* */
import java.util.Scanner;
import java.util.Stack;

public class QueueusingTwoStacks {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> reversedStack = new Stack<>();



    public static void main(String[] args) {
        QueueusingTwoStacks twoStacks = new QueueusingTwoStacks();
        Scanner scanner = new Scanner(System.in);
        String querySize = scanner.next();
        Integer dec = Integer.valueOf(querySize);
        while (dec> 0){
            Integer firstValue = scanner.nextInt();
            Integer secondValue = null;
            if(firstValue==1){
                secondValue = scanner.nextInt();
            }

            if(firstValue==1){
                twoStacks.enqueue(secondValue);
            }
            if(firstValue==2){
                twoStacks.dequeue();
            }
            if(firstValue==3){
                twoStacks.print();
            }


            dec --;


        }
        scanner.close();


    }

    public void enqueue(Integer integer){
        stack.push(integer);
    }

    public void dequeue(){
        shiftStack();
        reversedStack.pop();
    }

    private void shiftStack() {
        if(reversedStack.isEmpty()){
            while (!stack.isEmpty()){
                reversedStack.push(stack.pop());
            }
        }
    }

    public void print(){
        shiftStack();
        System.out.println(reversedStack.peek());
    }
}

