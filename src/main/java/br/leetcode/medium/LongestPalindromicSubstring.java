package br.leetcode.medium;

public class LongestPalindromicSubstring {


    //the idea is to start at the middle of the palindromic and check left and right sides if they are equals and keep expanding
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromMidle(s, i, i);
            int len2 = expandFromMidle(s, i, i+1);
            int len = Math.max(len1, len2);

            //if length >  previous palindromic size, then set start equals to current palindromic start index and end equals to current
            //palindromic end index
            if(len > end - start){
                start = i - ((len-1) / 2);
                end = i + (len/2);
            }

        }


        return s.substring(start, end + 1);
    }

    public int expandFromMidle(String s, int left, int right){
        if(s == null  || left > right) return 0;

        while (left >=0  && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;

        }
        //this calculus whill return the palidromic length
        return right - left -1 ;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring palindromicSubstring = new LongestPalindromicSubstring();
        System.out.println(palindromicSubstring.longestPalindrome("00000aabbaa"));
    }
}
