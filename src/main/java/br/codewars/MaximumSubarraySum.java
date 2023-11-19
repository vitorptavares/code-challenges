package br.codewars;

public class MaximumSubarraySum {

/*The maximum sum subarray problem consists in finding the maximum
sum of a contiguous subsequence in an array or list of integers:

Max.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
// should be 6: {4, -1, 2, 1}*/

    public static int sequence(int[] arr) {
        int maxNUm = 0;
        int currentSum = 0;

        for (int i = 0; i < arr.length ; i++) {
            currentSum = Math.max(arr[i],  currentSum + arr[i]);

            maxNUm = Math.max(currentSum, maxNUm);
        }
        return maxNUm;
    }


    public static void main(String[] args) {
        int sequence = MaximumSubarraySum.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(sequence);

    }
}
