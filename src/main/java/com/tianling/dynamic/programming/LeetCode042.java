package com.tianling.dynamic.programming;

import java.util.Stack;

/**
 * @author Tianling
 * @email 859073143@qq.com
 * @since 2021/4/11 12:32
 */
public class LeetCode042 {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int currentIndex = 0;
        while( currentIndex < height.length ){
            while (!stack.isEmpty() && height[currentIndex] > height[stack.peek()]){
                Integer pop = height[stack.peek()];
                stack.pop();
                if (stack.empty()){
                    break;
                }
                int dist = currentIndex - stack.peek()  -1;
                int min = Math.min(height[currentIndex], height[stack.peek()]);
                res += (min - pop) * dist;
            }
            stack.push(currentIndex++);
        }
        return res;
    }

    public static void main(String[] args) {
        new LeetCode042().trap(new int[]{1,2,3,4,5});
    }
}
