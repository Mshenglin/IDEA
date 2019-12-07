package org.array;

public class Q_27_0 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2,5,2,4,5,2};
        int val = 2;
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=val) {
                nums[k] = nums[i];
                k++;
            }
        }

        for (int i :
                nums) {
            System.out.print(i + "\t");
        }
    }
}
