package br.coderbyte.easy;

import java.util.Scanner;
import java.util.Stack;

public class QuestionMarks {

    /*Have the function QuestionsMarks(str) take the str string parameter, which will contain single digit numbers, letters,
    and question marks, and check if there are exactly 3 question marks between every pair of two numbers that add up
    to 10. If so, then your program should return the string true, otherwise it should return the string false.
    If there aren't any two numbers that add up to 10 in the string, then your program should return false as well.

    For example: if str is "arrb6???4xxbl5???eee5" then your program should return true because there are exactly 3
    question marks between 6 and 4, and 3 question marks between 5 and 5 at the end of the string.*/

    public static String QuestionsMarks(String str) {
        // code goes here

        Stack<Character> caracters = new Stack<>();
        int questionmarksCount = 0;
        boolean questionMarkResponse = false;
        Stack<Character> questionmarks = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if(c.toString().matches("[0-9]")){
                caracters.push(c);

            }
            if(caracters.size()==1 && c.equals('?')){
                questionmarksCount++;
                continue;
            }

            if(caracters.size()==2 && questionmarksCount>2){
                caracters.pop();
                caracters.pop();
                questionmarksCount=0;
                questionMarkResponse = true;
                continue;
            }
            if(caracters.size()==2 && questionmarksCount<=2 && questionmarksCount>10){
                questionMarkResponse = false;
                return String.valueOf(questionMarkResponse);
            }
        }
        if(caracters.size()>0)
            questionMarkResponse = false;
        return String.valueOf(questionMarkResponse);
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(QuestionsMarks(s.nextLine()));
    }
}
