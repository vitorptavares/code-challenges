package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
