package com.leetcode.easy;

//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//
//        You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//        You can return the answer in any order.
//        Example 1:
//
//        Input: nums = [2,7,11,15], target = 9
//        Output: [0,1]
//        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
//        Example 2:
//
//        Input: nums = [3,2,4], target = 6
//        Output: [1,2]
//        Example 3:
//
//        Input: nums = [3,3], target = 6
//        Output: [0,1]
//        Constraints:
//
//        2 <= nums.length <= 104
//        -109 <= nums[i] <= 109
//        -109 <= target <= 109
//        Only one valid answer exists.
//
//        Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
//

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> trackSet = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if(trackSet.containsKey(diff)){
                return new int[]{trackSet.get(diff), i};
            }
            trackSet.put(nums[i], i);
        }

        throw new IllegalArgumentException("Not found");
    }

    public static void main(String[] args) {
        int i[] = {3,4,7};
        System.out.println(Arrays.toString(twoSum(i, 10)));
    }
}
