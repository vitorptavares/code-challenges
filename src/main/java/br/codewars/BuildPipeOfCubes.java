package br.codewars;

public class BuildPipeOfCubes {

    public static void main(String[] args) {
        double sum = 0;
        Integer counter = 2147483639;
        for (int i = 1; i <46 ; i++) {
                sum =  (sum + Math.pow(Double.valueOf(i), Double.valueOf(3)));
        }
        System.out.println(sum);
    }
}
