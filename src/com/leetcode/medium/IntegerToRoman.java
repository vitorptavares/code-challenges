package com.leetcode.medium;


//https://leetcode.com/problems/integer-to-roman/

//        I             1
//        V             5
//        X             10
//        L             50
//        C             100
//        D             500
//        M             1000

/*
I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
*/
public class IntegerToRoman {
    public String intToRoman(int num) {
        int [] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String [] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            while (num >= numbers[i]){
                result.append(romans[i]);
                num-=numbers[i];
            }

        }
        return result.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman integerToRoman = new IntegerToRoman();
        System.out.printf(integerToRoman.intToRoman(1994));
    }
}
