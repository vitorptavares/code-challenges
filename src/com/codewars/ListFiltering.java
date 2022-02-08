package com.codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListFiltering {

    /*In this kata you will create a function that takes a list of non-negative integers and strings and returns a
    new list with the strings filtered out.

    Example
    Kata.filterList(Arrays.asList(1, 2, "a", "b")) => Arrays.asList(1,2)
    Kata.filterList(Arrays.asList(1, 2, "a", "b", 0, 15)) => Arrays.asList(1,2,0,15)
    Kata.filterList(Arrays.asList(1, 2, "a", "b", "aasf", "1", "123", 231)) => Arrays.asList(1, 2, 231)*/


    public static List filterList(final List list) {
        // Return the List with the Strings filtered out
        Object[] objects = list
                .stream().filter(obj -> obj instanceof Integer)
                .toArray();

        return Arrays.asList(objects);
    }

    public static void main(String[] args) {
        List<Object> objects = Arrays.asList(new Object[]{1,"a","b",0,15});
        List<Object> list = ListFiltering.filterList(objects);
        System.out.println(list);
    }
}
