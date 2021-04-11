package com.tianling.dynamic.programming;

/**
 * @author Tianling
 * @email 859073143@qq.com
 * @since 2021/4/11 15:48
 */
public class LeetCode044 {
    public boolean isMatch(String s, String p) {

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i < p.length() + 1; i++) {
           if(p.charAt(i-1) == '*'){
                dp[0][i] = dp[0][i-1];
           }
        }

        for (int i = 1; i < s.length() + 1; i++) {
            char current = s.charAt(i - 1);
            for (int j = 1; j < p.length() + 1; j++) {
                if(current == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1) == '*'){
                    if(dp[i][j-1]){
                        dp[i][j] = dp[i][j-1];
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
                }else{
                    dp[i][j] = false;
                }
            }
        }
        for (int i = 0; i < s.length() + 1 ; i++) {
            for (int j = 0; j < p.length() + 1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[s.length() ] [p.length()];
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode044().isMatch("aa", "a"));
    }
}
