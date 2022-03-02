package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {


        String[] v1Splited = splitVersions(version1);
        String[] v2Splited = splitVersions(version2);

        List<Integer> version1Splited = Arrays.stream(v1Splited).map(s -> removeLeftZeros(s)).map(Integer::valueOf).collect(Collectors.toList());
        List<Integer> version2Splited = Arrays.stream(v2Splited).map(s -> removeLeftZeros(s)).map(Integer::valueOf).collect(Collectors.toList());

        if(version1Splited.size() > version2Splited.size()){
            int diff = (version1Splited.size() - version2Splited.size());
            for (int i = 0; i < diff; i++) {
                version2Splited.add(0);
            }
        }

        if(version1Splited.size() < version2Splited.size()){
            int diff = (version2Splited.size() - version1Splited.size());
            for (int i = 0; i < diff; i++) {
                version1Splited.add(0);
            }
        }

        for (int i = 0; i < version1Splited.size(); i++) {
            int max = Math.max(2, 2);
            if(version1Splited.get(i) > version2Splited.get(i)){
                return 1;
            }else if (version1Splited.get(i) < version2Splited.get(i)){
                return -1;
            }

        }
        return 0;
    }

    private String[] splitVersions(String s){
        String[] splited = s.split("\\.");
        return splited;
    }

    private String removeLeftZeros(String s){
        if(Integer.valueOf(s) > 0){
            while (s.startsWith("0")){
                s = s.substring(1);
            }
        }
        return s;
    }

    public static void main(String[] args) {
        CompareVersionNumbers c = new CompareVersionNumbers();
        int i = c.compareVersion("1.0.1", "1");
        System.out.println(i);
    }
}
