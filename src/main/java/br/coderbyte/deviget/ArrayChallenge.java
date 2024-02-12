package br.coderbyte.deviget;

public class ArrayChallenge {


    /**
     * Have the java methoda rrayChallenge(arr) take the arr parameter being passed which will be an array
     * of non-negative integers and circularly rotate the array starting from the Nth element where N is equal
     * to the first integer in the array. For example: if arr is [2, 3, 4, 1, 6, 10] then your program should rotate
     * the array starting from the 2nd position because the first element in the array is 2.
     * The final array will therefore be [4, 1, 6, 10, 2, 3], and your program should return the new array as a string,
     * so for this example your program would return 4161023.
     * The first element in the array will always be an integer greater than or equal to 0 and less than the size of the array.
     * This method must return an integer
     * @param args
     */

    //solution 1

//    public static int ArrayChallenge(int[] arr) {
//        int rotate = arr[0] % arr.length;
//
//        int [] newArray = new int[arr.length];
//        for(int i=0; i < arr.length; i++){
//            newArray[i] = arr[(i + rotate) % arr.length];
//        }
//
//        int result = 0;
//        for(int integer : newArray){
//            result = result * 10 + integer;
//        }
//        arr[0] = result;
//        return arr[0];
//    }


    //best solution
    public static String ArrayChallenge(int[] arr) {

        StringBuilder result = new StringBuilder();
        for(int i = arr[0] ; i<arr.length ; i ++){
            result.append(arr[i]);
        }

        for (int j = 0 ; j<arr[0] ; j ++ ){
            result.append(arr[j]);
        }
        return result.toString();
    }


    public static void main(String[] args) {
        // Example usage:
        int[] arr1 = {2, 3, 4, 1, 6, 10};
        System.out.println(ArrayChallenge(arr1));  // Output: 4161023

        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println(ArrayChallenge(arr2));  // Output: 23451

        int[] arr3 = {3,2,1,6};
        System.out.println(ArrayChallenge(arr3));  // Output: 6321

        int[] arr4 = {4,3,4,3,1,2};
        System.out.println(ArrayChallenge(arr4));  // Output: 124343
    }
}
