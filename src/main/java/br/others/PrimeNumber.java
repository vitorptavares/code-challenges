package br.others;

public class PrimeNumber {

    public static void main(String[] args) {
        System.out.println(isPrimeNumber(11));



    }

    public static boolean isPrimeNumber(Integer number){
        for (int i = number-1; i > 1; i--) {
            if(number%i==0){
                return false;
            }
        }
        return true;
    }

}
