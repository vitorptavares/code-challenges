package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//
//Given string num representing a non-negative integer num, and an integer k,
// return the smallest possible integer after removing k digits from num.


public class RemoveKdigits {

    public String removeKdigits(String num, int k) {
        List<Integer> integers = new ArrayList<>();
        char[] chars = num.toCharArray();
        for (char c : chars) {
            integers.add(Integer.valueOf(c));
        }
        while (k > 0){
            Integer min = Collections.min(integers);
            integers.remove(min);
            k--;
        }
        return "";
    }

    public static void main(String[] args) {
        
    }
}
