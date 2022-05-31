package com.hackerrabk.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class HashTablesIceCreamParlor {

    /*
    * https://www.hackerrank.com/challenges/ctci-ice-cream-parlor/problem?h_r=internal-search
    *
    *
    * */


    /*
     * Complete the 'whatFlavors' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY cost
     *  2. INTEGER money
     */

    public static void whatFlavors(List<Integer> cost, int money) {
        // Write your code here

        //this is an not efficient way to solve this problem
//        outer:
//        for (int i = 0; i < cost.size(); i++) {
//
//            int j = i+1;
//            while (j<cost.size()){
//                if((cost.get(i) + cost.get(j)) == money){
//                    System.out.printf("%d %d", i+1,j+1);
//                    System.out.println("");
//                    break outer;
//                }
//                j++;
//        }
//    }

        //eficient way using hash
        Map<Integer, Integer> map = new HashMap();
        int x,y;
        //y = money - x
        for (int i = 0; i < cost.size(); i++) {
            x = cost.get(i);
            y = money-x;
            if (map.containsKey(y)){
                int positionX = ++i;
                System.out.println(map.get(y) + " " +  positionX);
                break;
            }
            else{
                map.put(cost.get(i), i+1);
            }
        }
}

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int money = Integer.parseInt(bufferedReader.readLine().trim());

                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> cost = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                HashTablesIceCreamParlor.whatFlavors(cost, money);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
