package com.tianling.dynamic.programming;

/**
 * @author Tianling
 * @email 859073143@qq.com
 * @since 2021/4/13 22:59
 */
public class LeetCode101 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        if(root.left == null && root.right == null){
            return true;
        }

        if(root.left == null || root.right == null){
            return false;
        }
        return isSymmetric(root.left,root.right);

    }
    public boolean isSymmetric(TreeNode p, TreeNode q) {
        if( p==null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        if(p.val == q.val){
            return isSymmetric(p.left,q.right) &&  isSymmetric(p.right,q.left);
        }

        return false;

    }


}
