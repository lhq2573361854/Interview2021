package com.tianling.dynamic.programming;

/**
 * @author Tianling
 * @email 859073143@qq.com
 * @since 2021/4/13 17:55
 */
public class LeetCode783 {






    int pre = -1;
    int res = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        dfs(root);
       return res;
    }

    private void dfs(TreeNode root){
        if(root == null){
            return ;
        }
        dfs(root.left);
        if (pre != -1) {
            res = Math.min(root.val - pre, res);
        }
        pre = root.val;

        dfs(root.right);
    }

}

