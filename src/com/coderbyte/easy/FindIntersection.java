package com.coderbyte.easy;

import java.util.*;

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
