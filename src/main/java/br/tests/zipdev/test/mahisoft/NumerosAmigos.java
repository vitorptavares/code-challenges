package br.tests.zipdev.test.mahisoft;

import java.util.Scanner;

public class NumerosAmigos {

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {


        int a = scanner.nextInt();

        int b = scanner.nextInt();

        scanner.close();

        Boolean result = solution(a,b);

        System.out.println(result ? "True" : "False");

    }

    static Boolean solution(int a, int b) {
        int sum=0;
        for(int i = 1;i < a;i++){
            if(a%i==0){
                sum+=i;
            }
        }
        if(sum==b){
            sum=0;
            for(int i = 1;i < b;i++){
                if(b%i==0){
                    sum+=i;
                }
            }
            if(sum==a){
                return true;
            }
        }
        return false;
    }
}
