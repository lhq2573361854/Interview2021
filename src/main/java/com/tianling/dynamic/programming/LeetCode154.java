package com.tianling.dynamic.programming;

/**
 * @author Tianling
 * @email 859073143@qq.com
 * @since 2021/4/11 15:44
 */
public class LeetCode154 {
    public int minArray(int[] numbers) {
        int length = numbers.length;
        if(length == 1) {
            return numbers[0];
        }
        for (int i = 1; i < length; i++) {
            if(numbers[i] < numbers[i-1]){
                return numbers[i];
            }

        }
        return numbers[0];
    }
}
