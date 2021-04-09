package com.tianling.dynamic.programming;

/**
 * @author Tianling
 * @email 859073143@qq.com
 * @since 2021/4/8 18:19
 */
public class LeetCode978 {
    public int maxTurbulenceSize(int[] arr) {
        int up = 1 , down = 1 ,res = 1;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i-1] < arr[i]){
                up = down + 1;
                down = 1;
            }else if(arr[i-1] > arr[i]){
                down = up + 1;
                up = 1;
            }else{
                up = 1;
                down = 1;
            }
            res = Math.max(res,Math.max(up,down));
        }
        return res;
    }

    public static void main(String[] args) {
        int i = new LeetCode978().maxTurbulenceSize(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9});
        System.out.println("i = " + i);
    }
}
