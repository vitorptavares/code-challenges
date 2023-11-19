package br.coderbyte.easy;

import java.util.Scanner;

public class FirstReverse {

    /*Have the function FirstReverse(str) take the str parameter being passed and return the string in reversed order.
     For example: if the input string is "Hello World and Coders" then your program should return the string sredoC dna dlroW olleH
   .*/

    public static String FirstReverse(String str) {
        // code goes here
        StringBuilder reverseString = new StringBuilder();
        for (int i = str.length() -1 ; i >=0 ; i--) {
            reverseString.append(str.charAt(i));
        }
        return reverseString.toString();
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(FirstReverse(s.nextLine()));
    }
}
