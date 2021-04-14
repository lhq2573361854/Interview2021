package com.tianling.dynamic.programming;

/**
 * @author Tianling
 * @email 859073143@qq.com
 * @since 2021/4/13 22:53
 */
public class LeetCode100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p,q);
    }

    public boolean dfs(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }
        if(p==null || q ==null){
            return false;
        }
        if(p.val == q.val){
            return dfs(p.left,q.left) && dfs(p.right,q.right);
        }
        return false;
    }
}
