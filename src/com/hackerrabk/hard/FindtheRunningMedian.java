package com.hackerrabk.hard;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FindtheRunningMedian {
    /*
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static List<Double> runningMedian(List<Integer> a) {
        // Write your code here
         //I´ll split the inst into two heaps. One containing the half lowest values ordered by decreasing order and other containing half highest values ordered by increasing
        //I´ll new change the natural comparison to put biggest elements on top, so I´ll implement Comparator
        PriorityQueue<Integer> lowersNumbers = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        PriorityQueue<Integer> highersNumbers = new PriorityQueue<Integer>();

        List<Double> medians = new ArrayList<>();
        int mediansIndex = 0;
        //add number into one of the heaps
        //now I need rebelance to garantee each heap contains the same number
        a.forEach(integer -> {
            addNumber(integer, lowersNumbers, highersNumbers);
            rebalance(lowersNumbers, highersNumbers);
            medians.add(getMedian(lowersNumbers, highersNumbers));
        });
        return medians;

    }

    //PriorityQueue will be used to imlement our own comparator
    private static double getMedian(PriorityQueue<Integer> lowersNumbers, PriorityQueue<Integer> highersNumbers) {
        PriorityQueue<Integer> biggerHeap = lowersNumbers.size() > highersNumbers.size() ? lowersNumbers : highersNumbers;
        PriorityQueue<Integer> smallerHeap = lowersNumbers.size() > highersNumbers.size() ? highersNumbers : lowersNumbers;

        if(biggerHeap.size() == smallerHeap.size()){
            //we need convert to double since we can have decimals to represent the medium

            return  ((double) biggerHeap.peek() + smallerHeap.peek()) /2d;

        } else {
            return biggerHeap.peek();
        }

    }

    private static void rebalance(PriorityQueue<Integer> lowersNumbers, PriorityQueue<Integer> highersNumbers) {
        PriorityQueue<Integer> biggerHeap = lowersNumbers.size() > highersNumbers.size() ? lowersNumbers : highersNumbers;
        PriorityQueue<Integer> smallerHeap = lowersNumbers.size() < highersNumbers.size() ? lowersNumbers : highersNumbers;

        //the difference can be max 1 since we can have odd numbers
        if(biggerHeap.size() - smallerHeap.size() >=2){
            smallerHeap.add(biggerHeap.poll());
        }
    }

    private static void addNumber(Integer number, PriorityQueue<Integer> lowersNumbers, PriorityQueue<Integer> highersNumbers) {
        if(lowersNumbers.size() == 0 || number < lowersNumbers.peek()){
            lowersNumbers.add(number);
        }else {
            highersNumbers.add(number);
        }
    }

}

 class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Double> result = FindtheRunningMedian.runningMedian(a);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }

}
