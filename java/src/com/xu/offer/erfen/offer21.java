package com.xu.offer.erfen;

import java.util.Arrays;

public class offer21 {
    public static void main(String[] args) {
        Thread thread=new Thread();
         int[] nums=new int[]{1,2,3,4};
        System.out.println(Arrays.toString(exchange(nums)));
    }
    public static int[] exchange(int[] nums) {
        //使用双指针i是快指针，j是慢指针
        int i=0,j=0;
        while(i<=nums.length-1) {
            if ((nums[i] % 2) == 1) {
                if (i != j) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    j++;
                }
                i++;
            }
        }
        return nums;
    }
}
