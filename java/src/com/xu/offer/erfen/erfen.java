package com.xu.offer.erfen;

import java.util.ArrayList;

public class erfen {
    public static void main(String[] args) {
        int[] nums=new int[]{2,5};
        int search=search(nums,5);
        System.out.println(search);

    }
    public  static int search(int[] nums, int target) {
        //二分查找的左边界
        int left=0;
        //二分查找的右边界
        int right=nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            //当mid索引数组的值，等于目标值，直接返回
            if(nums[mid]==target){
                return mid;
            }
            //中间位置的值小于目标值，缩小左边界
            else if(nums[mid]<target){
                left=mid+1;
            }
            else{
                right=mid;
            }
        }
        return -1;
    }
}
