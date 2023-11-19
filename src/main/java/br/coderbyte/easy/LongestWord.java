package br.coderbyte.easy;

import java.util.Scanner;

public class LongestWord {

    /*Have the function LongestWord(sen) take the sen parameter being passed and return the longest word in the string.
    If there are two or more words that are the same length, return the first word from the string with that length.
    Ignore punctuation and assume sen will not be empty.
    Words may also contain numbers, for example "Hello world123 567"*/

    public static String LongestWord(String sen) {
        // code goes here
        String[] words = sen.replaceAll("\\p{Punct}", "").split("\\s+");
        String biggestWord = "";
        for (String word :
                words) {
            if (word.length() > biggestWord.length()) {
                biggestWord = word;
            }
        }
        return biggestWord;
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(LongestWord(s.nextLine()));
    }
}
