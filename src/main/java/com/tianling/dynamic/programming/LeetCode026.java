package com.tianling.dynamic.programming;

/**
 * @author Tianling
 * @email 859073143@qq.com
 * @since 2021/4/18 13:28
 */
public class LeetCode026 {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 1){
            return nums.length;
        }
        int fast = 1;
        int slow = 1;
        while(fast < nums.length){
            if(nums[fast] != nums[fast-1]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return  slow;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode026().removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));

    }
}
