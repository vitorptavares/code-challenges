package com.codewars;


/*Complete the method/function so that it converts dash/underscore delimited words into camel casing.
The first word within the output should be capitalized only if the original word was capitalized (known as Upper Camel Case,
also often referred to as Pascal case).

Examples
"the-stealth-warrior" gets converted to "theStealthWarrior"
"The_Stealth_Warrior" gets converted to "TheStealthWarrior"*/
public class ConvertCamelCase {
    private static char UNDERSCORE = '_';
    private static char DASH = '-';

    static String toCamelCase(String s){
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if(chars[i]==UNDERSCORE || chars[i]==DASH){
                chars[i+1]= Character.toUpperCase(chars[i+1]);

            }
        }

        return String.valueOf(chars).replaceAll("[_-]*","");
    }

    public static void main(String[] args) {
        String s = ConvertCamelCase.toCamelCase("The_Stealth_Warrior");
        System.out.println(s);
    }
}
