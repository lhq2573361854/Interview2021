package com.tianling.dynamic.programming;

/**
 * @author Tianling
 * @email 859073143@qq.com
 * @since 2021/4/9 21:12
 */
public class LeetCode003 {

    public String longestPalindrome(String s) {
        int length = s.length();
        boolean [][] dp = new boolean[length][length];

        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        int maxLen = 1;
        int beginIndex =  0;
        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                if(s.charAt(i) == s.charAt(j)){
                    if(j - i < 3 ){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }else{
                    dp[i][j] = false;
                }
                if(dp[i][j] && j - i + 1 > maxLen){

                    beginIndex = i;
                    maxLen = j - i + 1;

                }
            }
        }
        return s.substring(beginIndex, beginIndex + maxLen);
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode003().longestPalindrome("babad"));

    }
}
