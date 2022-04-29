package com.leetcode.medium;

public class ReverseInteger {
    public int reverse(Integer x) {
        String s= String.valueOf(x);
        boolean isNegative = false;
        if(x > Integer.MAX_VALUE || x < Integer.MIN_VALUE){
            return 0;
        }
        if(x < 0){
            s = s.substring(1);
            isNegative= true;
        }


        String reversed = "";
        for (int i = s.length()-1 ; i>=0 ; i--){
            reversed += s.charAt(i);
        }
        if(isNegative){
            return Long.valueOf(reversed)*-1 > Integer.MIN_VALUE ? Integer.valueOf(reversed)*-1 : 0;
        }
        return Long.valueOf(reversed) < Integer.MAX_VALUE ? Integer.valueOf(reversed) : 0;
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(-2147483648));
        Integer t = -2147483648;
    }
}
