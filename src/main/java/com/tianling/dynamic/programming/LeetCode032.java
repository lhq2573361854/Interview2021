package com.tianling.dynamic.programming;

/**
 * @author Tianling
 * @email 859073143@qq.com
 * @since 2021/4/10 19:04
 */
public class LeetCode032 {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int max  = 0;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == ')'){
                if(s.charAt(i - 1) == '('){
                    dp[i] = (i >= 2 ? dp[i - 2] : 0)  + 2;
                }else if(i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1 ) == '('){
                    dp[i] = dp[i -1] +  ((i - dp[i - 1]) >= 2 ? dp[i  - dp[i - 1] - 2 ]: 0 ) + 2 ;
                }
                max = Math.max(dp[i],max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode032().longestValidParentheses(")(((((()())()()))()(()))("));
    }
}



