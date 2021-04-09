package com.tianling.dynamic.programming;

import java.sql.SQLOutput;

/**
 * @author Tianling
 * @email 859073143@qq.com
 * @since 2021/4/8 17:00
 */
public class LeetCode300 {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                 if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[j]+ 1,dp[i]);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res,dp[i]);
        }
        return res;
    }


}
