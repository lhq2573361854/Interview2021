package com.tianling.dynamic.programming;

/**
 * @author Tianling
 * @email 859073143@qq.com
 * @since 2021/4/15 22:52
 */
public class LeetCode213 {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[nums.length-1];
        }
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        int[] dp1 = new int[nums.length] ;
        int[] dp2 = new int[nums.length] ;
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < dp1.length - 1; i++) {
            dp1[i] = Math.max(dp1[ i - 2] + nums[i] , dp1[i - 1]);
        }
        dp2[1] = nums[1];
        dp2[2] = Math.max(nums[1],nums[2]);
        for (int i = 3; i < dp2.length; i++) {
            dp2[i] = Math.max(dp2[ i - 2] + nums[i] , dp2[i - 1]);
        }
        return  Math.max(dp1[dp1.length-2],dp2[dp2.length-1]);
    }

    public static void main(String[] args) {
        int rob = new LeetCode213().rob(new int[]{1,3,1,3,100});
        System.out.println("rob = " + rob);
    }
}
