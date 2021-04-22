package com.tianling.dynamic.programming;

/**
 * @author Tianling
 * @email 859073143@qq.com
 * @since 2021/4/22 22:21
 */
public class LeetCode091 {
    public int numDecodings(String s) {

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            if(s.charAt(i - 1) != '0'){
                dp[i] += dp[i-1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {

    }
}
