package com.tianling.dynamic.programming;

/**
 * @author Tianling
 * @email 859073143@qq.com
 * @since 2021/4/22 21:43
 */
public class LeetCode027 {
    public int removeElement(int[] nums, int val) {
       int n = nums.length;
       int i = 0;
       int j = 0;
        for ( ; i  < n ; i++) {
            if( nums[i] == val ){
                continue;
            }
            nums[i] = nums[j];
            j++;
        }
        return j;
    }

    public static void main(String[] args) {
        LeetCode027 leetCode027 = new LeetCode027();
        int i = leetCode027.removeElement(new int[]{3, 2, 2, 3}, 2);
        System.out.println("i = " + i);
    }
}
