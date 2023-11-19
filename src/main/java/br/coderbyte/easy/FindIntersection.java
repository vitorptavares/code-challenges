package br.coderbyte.easy;

import java.util.*;

/*
FindIntersection(strArr) read the array of strings stored in strArr which will contain 2 elements:
the first element will represent a list of comma-separated numbers sorted in ascending order,
the second element will represent a second list of comma-separated numbers (also sorted).
Your goal is to return a comma-separated string containing the numbers that occur in elements of strArr in sorted order.
If there is no intersection, return the string false.

Input: ["1, 3, 4, 7, 13", "1, 2, 4, 13, 15"]
Output: 1,4,13

Input: ["1, 3, 9, 10, 17, 18", "1, 4, 9, 10"]
Output: 1,9,10
 */

public class FindIntersection {

    public static void FindIntersection(String[] strArr) {
        Set<String> items = new HashSet<>();
        Set<String> setNumbers = new HashSet<>();
        Arrays.stream(strArr).forEach(text->{
            List<String> listItems = Arrays.asList(text.split("\\s*,\\s*"));
            for (int i = 0; i < listItems.size(); i++) {
                if(!items.add(listItems.get(i))){
                    setNumbers.add(listItems.get(i));
                }
            }
        });

        for (String c :
                setNumbers) {
            System.out.print(c);
            System.out.print(",");
        }
    }

    public static void main (String[] args) {
        // keep this function call here
    //    Scanner s = new Scanner(System.in);
   //     System.out.print(FindIntersection(s.nextLine()));
        FindIntersection( new String[] {"1, 3, 4, 7, 13", "1, 2, 4, 13, 15"});
    }
}
