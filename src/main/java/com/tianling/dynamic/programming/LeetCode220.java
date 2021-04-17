package com.tianling.dynamic.programming;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * @author Tianling
 * @email 859073143@qq.com
 * @since 2021/4/17 21:07
 */
public class LeetCode220 {
    private Long val;
    // 滑动窗口
    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        int length = nums.length;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < length; i++) {
            Long u = (long) nums[i];
            Long ceiling = set.ceiling(u);
            Long floor = set.floor(u);

            if(ceiling != null && ceiling - u <= t ){
                return true;
            }

            if(floor != null && u - floor <= t ){
                return true;
            }
            set.add(u);

            if (i >= k) {
                set.remove((long) nums[i - k]);
            }

        }
        return false;
    }
    // 桶排序
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        HashMap<Long, Long> map = new HashMap<>();
        this.val =  (long) t + 1;
        for (int i = 0; i < nums.length; i++) {
            Long id = getId(nums[i]);
            if(map.containsKey(id)){
                return true;
            }
            if(map.containsKey(id - 1) && Math.abs(nums[i] - map.get(id-1)) < val){
                return true;
            }
            if(map.containsKey(id + 1)  && Math.abs( map.get(id+1) - nums[i]) < val){
                return true;
            }
            map.put(id, (long) nums[i]);

            if(i >= k){
               map.remove(getId(nums[i-k]));
            }

        }
        return false;

    }
    private Long getId(int num){
        if(num >= 0){
            return num / val;
        }else{
            return (num + 1) /val - 1;
        }
    }
    public static void main(String[] args) {
        System.out.println(-1/4);
    }
}
