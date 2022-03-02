package com.codewars;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class WeightForWeight {

    public static void main(String[] args) {
        WeightForWeight.orderWeight("11 11 2000 10003 22 123 1234000 44444444 9999");
    }

    public static String orderWeight(String strng) {
//        String[] s = strng.split(" ");
        int [] s = Stream.of(strng.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int [] weight = new int[s.length];
        int [] sum;
        sum = calculateSum(s);

        int [][] result = new int[2][s.length];
        result[0] = s;
        result[1] = sum;

        int[][] ints = sortArray(result);
        System.out.println(Arrays.toString(result[0]));
        System.out.println(Arrays.toString(result[1]));

        return "";



        // your code
    }

    public static int [][] sortArray(int[][] values){
        for(int i = 0 ; i < values.length; i ++){
            for(int j = 1 ; j < values[i].length ; j ++){
                if(i != 0){
                    if(values[i][j-1] > values[i][j] ){

                        for(int k = j;k>0;k--){

                            if(values[i][k-1] > values[i][k] ){
                                int temp1 = values[i][k-1];
                                values[i][k-1] =  values[i][k];
                                values[i][k] = temp1;
                                int temp2  = values[i-1][k-1];
                                values[i-1][k-1] =  values[i-1][k];
                                values[i-1][k] = temp2;
                            }
                        }
                    }
                }
            }
        }
        return values;
    }

    public static int [] calculateSum(int [] s){
        int [] sum = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            char[] splitedNumber = String.valueOf(s[i]).toCharArray();
            int sumDigits = 0;
            for (char splited : splitedNumber) {
                sumDigits +=Integer.parseInt(String.valueOf(splited));
            }
            sum[i] = sumDigits;
        }
        return sum;
    }
}
