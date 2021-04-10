package com.tianling.dynamic.programming;

/**
 * @author Tianling
 * @email 859073143@qq.com
 * @since 2021/4/10 12:02
 */
public class LeetCode010 {
    public static void main(String[] args) {
        LeetCode010 leetCode010 = new LeetCode010();
        System.out.println(leetCode010.isMatch("ab", ".*"));
    }

    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i < p.length() + 1; i++) {
            char c = p.charAt(i - 1);
            if (i > 1) {
                if (c == '*') {
                    // 如果前面匹配过
                    dp[0][i] = dp[0][i - 2];
                } else {
                    // 空和点都不匹配
                    dp[0][i] = false;
                }
            } else {
                // 如果前面没有匹配过的话
                if (c == '*') {
                    dp[0][i] = true;
                }
            }
        }
        for (int i = 1; i < s.length() + 1; i++) {
            // 获取当前的 字母
            char current = s.charAt(i - 1);
            for (int j = 1; j < p.length() + 1; j++) {
                // 如果当前字母是点或者对应字母的话
                if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == current) {
                    dp[i][j] = dp[i - 1][j - 1];
                    // 如果当前字母是 *
                } else if (p.charAt(j - 1) == '*') {
                    // 如果没有这个字母的话
                    if (dp[i][j - 2]) {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        // 如果有一个的话
                        char previous = p.charAt(j - 2);
                        if (previous == current || previous == '.') {
                            dp[i][j] = dp[i - 1][j];
                        }
                    }
                }else{
                    //字母不匹配的话
                    dp[i][j] = false;
                }

            }
        }
        return dp[s.length() ] [p.length()];
    }
}
