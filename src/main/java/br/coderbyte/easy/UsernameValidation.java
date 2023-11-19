package br.coderbyte.easy;

import java.util.Scanner;

public class UsernameValidation {

    /*Have the function QuestionsMarks(str) take the str string parameter,
    which will contain single digit numbers, letters, and question marks,
    and check if there are exactly 3 question marks between every pair of two numbers that add up to 10.
    If so, then your program should return the string true, otherwise it should return the string false.
    If there aren't any two numbers that add up to 10 in the string, then your program should return false as well.

    For example: if str is "arrb6???4xxbl5???eee5" then your program should return true because there are exactly 3
    question marks between 6 and 4, and 3 question marks between 5 and 5 at the end of the string.*/

    public static String CodelandUsernameValidation(String str) {
        // code goes here
        if(isValidateSize(str) && isLetterStarting(str) && !isLastCharUnderscore(str))
         return "true";
        return "false";
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(CodelandUsernameValidation(s.nextLine()));
    }

    private static boolean isValidateSize(String str){
       return ( str.length()>4 && str.length()<25) ? true: false;
    }

    private static boolean isLetterStarting(String str){
        return str.substring(0,1).matches("[a-zA-Z]");
        //Matcher matcher = Pattern.compile("[a-zA-Z]").matcher(str.substring(0, 1));
        //return matcher.matches()? true:false;
    }

    private static boolean isLastCharUnderscore(String str){
        return str.endsWith("_") ? true:false;
    }
}
