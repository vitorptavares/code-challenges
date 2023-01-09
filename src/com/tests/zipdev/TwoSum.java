package com.tests.zipdev;


// Create a function which finds all pairs of numbers in a given array
// which sum is equal to a given value
// Example #1: [4,1,2,3,3], 6 -> [[2,4], [3,3]]
// Example #2: [3,3,3], 6 -> [[3,3], [3,3], [3,3]]


import java.util.ArrayList;
import java.util.List;

public class TwoSum {

    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        int [] integersInput = {3,3,3};
        int value = 6;

        for (int i = 0; i < integersInput.length; i++) {
            for (int j = i+1; j < integersInput.length; j++) {
                if(integersInput[i] + integersInput[j]==value){
                    List<Integer> resultLine = new ArrayList();
                    resultLine.add(integersInput[i]);
                    resultLine.add(integersInput[j]);
                    result.add(resultLine);
                }
            }
        }
        result.forEach(integers -> System.out.println(integers));
    }
}
