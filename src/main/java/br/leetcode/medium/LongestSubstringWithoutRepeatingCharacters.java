package br.leetcode.medium;

import java.util.HashSet;


//    Given a string s, find the length of the longest substring without repeating characters.
//Examplea
//
//        Input: s = "abcabcbb"
//        Output: 3
//        Explanation: The answer is "abc", with the length of 3.
//        Example 2:
//
//        Input: s = "bbbbb"
//        Output: 1
//        Explanation: The answer is "b", with the length of 1.
//        Example 3:
//
//        Input: s = "pwwkew"
//        Output: 3
//        Explanation: The answer is "wke", with the length of 3.
//        Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

public class LongestSubstringWithoutRepeatingCharacters {


    public int lengthOfLongestSubstring(String s) {
        int a= 0;
        int b = 0;
        int longestSub = 0;

        HashSet<Character> caracters = new HashSet<>();
        while ( b < s.length()){
            if(!caracters.contains(s.charAt(b))){
                caracters.add(s.charAt(b));
                b++;
                longestSub  = Math.max(caracters.size(), longestSub);
            }
            else{
                caracters.remove(s.charAt(a));
                a++;
            }
        }
        return longestSub;
    }


}
