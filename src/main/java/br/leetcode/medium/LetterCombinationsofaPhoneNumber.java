package br.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {

    public static void main(String[] args) {

        letterCombinations("23");

    }

    public static List<String> letterCombinations(String digits) {
        List<List<Character>> characters= new ArrayList<>();

        List<Character> two =new ArrayList<>();
        two.add('a');
        two.add('b');
        List<Character> three =new ArrayList<>();
        two.add('d');
        two.add('e');
        two.add('f');
        List<Character> four =new ArrayList<>();
        two.add('g');
        two.add('h');
        two.add('i');
        List<Character> five =new ArrayList<>();
        two.add('j');
        two.add('k');
        two.add('l');
        List<Character> six =new ArrayList<>();
        two.add('m');
        two.add('n');
        two.add('o');
        List<Character> seven =new ArrayList<>();
        two.add('p');
        two.add('q');
        two.add('r');
        two.add('s');
        List<Character> eight =new ArrayList<>();
        two.add('t');
        two.add('u');
        two.add('v');
        List<Character> nine =new ArrayList<>();
        two.add('w');
        two.add('x');
        two.add('y');
        two.add('z');



        String[] numbers = digits.split("");
       // numbers.

        for (int i = 0; i < numbers.length-1; i++) {
            List<Character> charsToBePrintedOne = characters.get(i);
            for (int j = i+1; j < numbers.length; j++) {
                List<Character> charsToBePrintedTwo = characters.get(j);
                System.out.println(charsToBePrintedOne.get(i) + charsToBePrintedTwo.get(j));

            }

        }
        return null;

    }
}
