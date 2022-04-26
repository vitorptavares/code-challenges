package com.hackerrabk.medium;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Contacts {

    public static Trie trie;
    /*
     * Complete the 'contacts' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts 2D_STRING_ARRAY queries as parameter.
     */


    /* Based loosely on tutorial video in this problem */
    class TrieNode {
        private HashMap<Character, TrieNode> children = new HashMap();
        public int size = 0; // this was the main trick to decrease runtime to pass tests.

        public void putChildIfAbsent(char ch) {
            children.putIfAbsent(ch, new TrieNode());
        }

        public TrieNode getChild(char ch) {
            return children.get(ch);
        }
    }

    class Trie {
        TrieNode root = new TrieNode();

        public void add(String str) {
            TrieNode curr = root;
            for (char ch : str.toCharArray()) {
                curr.putChildIfAbsent(ch);
                curr = curr.getChild(ch);
                curr.size++;
            }
        }

        public int find(String prefix) {
            TrieNode curr = root;
            for (char ch : prefix.toCharArray()) {
                curr = curr.getChild(ch);
                if (curr == null) {
                    return 0;
                }
            }
            return curr.size;
        }

    }

    public static List<Integer> contacts(List<List<String>> queries) {
        // Write your code here



//        List<String> names = new ArrayList<>();
//        List<Integer> countNames = new ArrayList<>();
//      queries.stream().forEach(strings -> {
//          if(strings.get(0)!=null && !strings.get(0).isEmpty() && strings.get(1)!=null && !strings.get(1).isEmpty()){
//              if(strings.get(0).equals("add")){
//                  names.add(strings.get(1));
//              }
//              else if(strings.get(0).equals("find")){
//                  long count = names.stream().filter(s -> s.startsWith(strings.get(1))).count();
//                  countNames.add(Long.valueOf(count).intValue());
//              }
//              else{
//                  countNames.add(0);
//              }
//          }
//      });
//      return countNames;
return new ArrayList<>();
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        File inputFile = new File(
                "C:\\Users\\vitor\\Documents\\input.txt");
        File outputFile = new File(
                "C:\\Users\\vitor\\Documents\\output.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile));

        int queriesRows = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> queries = new ArrayList<>();

        IntStream.range(0, queriesRows).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Contacts.contacts(queries);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
