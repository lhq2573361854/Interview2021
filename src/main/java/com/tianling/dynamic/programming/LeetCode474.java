package com.tianling.dynamic.programming;

import java.util.Arrays;

/**
 * @author Tianling
 * @email 859073143@qq.com
 * @since 2021/4/8 16:55
 */
public class LeetCode474 {

    class TwoTuple {

        private int  first;

        private int  second;

        public TwoTuple(int a, int b){
            first = a;
            second = b;
        }

        @Override
        public String toString(){
            return "(" + first + ", " + second + ")";
        }

    }

    /**
     *
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        TwoTuple[] strings = new TwoTuple[strs.length];

        for (int i = 0; i < strs.length; i++) {
            int ctn1 = (int)(Arrays.stream(strs[i].split("")).mapToInt(Integer::valueOf).filter(j -> j == 0 ).count());
            int ctn2 = (int)(Arrays.stream(strs[i].split("")).mapToInt(Integer::valueOf).filter(j -> j == 1 ).count());
            TwoTuple tuple = new TwoTuple(ctn1,ctn2);
            strings[i] = tuple;
        }

        Object[] tuples = Arrays.stream(strings).sorted((t1, t2) -> {
            if (t1.first != t2.first) {
                return t1.first - t2.first;

            } else if (t1.second != t2.second) {

                return t1.second - t2.second;
            }
            return 0;
        }).toArray();

        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i < tuples.length; i++) {

            TwoTuple t1 = (TwoTuple) tuples[i];

            for (int j = m; j >= t1.first ; j--) {
                for (int k = n; k >= t1.second; k--) {
                    dp[j][k] = Math.max(dp[j][k],dp[j-t1.first][k-t1.second] + 1);
                }
            }
        }


        return dp[m][n];
    }
}
