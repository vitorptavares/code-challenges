package br.tests.zipdev.test.mahisoft;


import java.util.Scanner;

public class AlgoritmoDecompressao {
    static String solution(String s) {
        char [] chars = s .toCharArray();
        StringBuilder result = new StringBuilder();
        int repeated = 1;
        for(int i = 0; i < chars.length; i++)
        {
            if(i< chars.length-1){
                if(chars[i]==chars[i+1]){
                    repeated++;
                }
                else {
                    if(repeated>1){
                        result.append(repeated);
                    }
                    result.append(chars[i]);

                    repeated=1;
                }
            }
            if( i== chars.length-1 && repeated>1){
                result.append(repeated).append(chars[i]);
            }
        }
        return result.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String s = scanner.nextLine();

        scanner.close();

        String result = solution(s);

        System.out.println(result);

    }
}
