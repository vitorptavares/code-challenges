package br.hackerrank.medium;

import java.io.*;

import java.util.Stack;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

public class BalancedBrackets {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
        // Write your code here
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            }
            else{
                if (stack.isEmpty()) {
                    return "NO";
                } else {
                    char poped = stack.pop();
                    if (s.charAt(i) == ')' && poped != '(')
                        return "NO";
                    else if (s.charAt(i) == ']' && poped != '[')
                        return "NO";
                    else if (s.charAt(i) == '}' && poped != '{')
                        return "NO";
                }
            }
        }
        if (stack.isEmpty())
            return "YES";

        return "NO";
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = BalancedBrackets.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
