package br.tests.zipdev.test.mahisoft;

import java.util.ArrayList;
import java.util.List;

class WordFinder {

    private static final String[] letterGroup = {"l","e","a","g","u","e","a","p","p","s"};

    public static void main (String[] args) {


        final String word1 = "LeagueApps"; // Should return true
        final String word2 = "League Apps"; // Should return true
        final String word3 = "LeagueAppps"; // Should return false
        final String word4 = "Applause"; // Should return true
        final String word5 = "SportsDog"; // Should return false

        WordFinder wf = new WordFinder();

        System.out.println(wf.testWord(word1) ? "true" : "false");
        System.out.println(wf.testWord(word2) ? "true" : "false");
        System.out.println(wf.testWord(word3) ? "true" : "false");
        System.out.println(wf.testWord(word4) ? "true" : "false");
        System.out.println(wf.testWord(word5) ? "true" : "false");
    }

    private boolean testWord(final String word) {
        List<Character> charOfWord = new ArrayList<>();
        List<Character> charOfLetters = new ArrayList<>();
        for (char ch : word.toCharArray()) {
            charOfWord.add(ch);
        }
       // letterGroup.length


        for (char ch : letterGroup.toString().toCharArray()) {
            charOfLetters.add(ch);
        }
        //   char[]  charOfWord= word.toCharArray();
        for(int i=0; i < charOfWord.size() ; i++){
            if(!charOfWord.contains(charOfLetters.get(i))){
                return false;
            }
            charOfLetters.remove(i);
        }
        return true;
    }
}
