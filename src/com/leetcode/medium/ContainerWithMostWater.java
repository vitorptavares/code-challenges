package com.leetcode.medium;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length-1;

        while (left < right){
            //bellow calculus represents area Calculus (length X height) for each point of the array (right - left);
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, area);
            //the idea bellow is maintain the bigger size and reduce the smaller one from the array. This way we don´t need go through
            //every arrays positions and test them against the whole array
            if(height[left] > height[right])
                right --;
            else
                left++;

        }
        return maxArea;

    }
}