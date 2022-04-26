package com.leetcode.medium;

public class ReverseInteger {
    public int reverse(Integer x) {
        if(x > Integer.MAX_VALUE || x < Integer.MIN_VALUE)

        return 0;

        String s= String.valueOf(x);
        String reversed = "";
        for (int i = s.length()-1 ; i>=0 ; i--){
            reversed += s.charAt(i);
        }
        return Integer.valueOf(reversed);
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(123));
    }
}
