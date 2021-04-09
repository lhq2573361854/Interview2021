package com.tianling.dynamic.programming;

/**
 * @author Tianling
 * @email 859073143@qq.com
 * @since 2021/4/8 16:56
 */
public class LeetCode600 {
    public int findIntegers(int num) {
        String s = Integer.toBinaryString(num);
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i <= s.length(); i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1'){
                sum+=dp[s.length() - i - 1];
                if(i> 0  && s.charAt(i-1) == '1'){
                    return sum;
                }
            }
        }
        return ++sum;
    }
}
