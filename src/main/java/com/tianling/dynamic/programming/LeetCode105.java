package com.tianling.dynamic.programming;

/**
 * @author Tianling
 * @email 859073143@qq.com
 * @since 2021/4/13 23:26
 */
public class LeetCode105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,inorder,0, preorder.length-1, 0,inorder.length-1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder,int n1,int n2,int m1,int m2) {
        if(n1 == n2){
            return new TreeNode(preorder[n1]);
        }
        if(m1 == m2){
            return new TreeNode(inorder[m1]);
        }


        int i = preorder[n1];

        TreeNode treeNode = new TreeNode(i);
        int count = 0;
        // 找出在中序便利的位置
        for (int j = m1; j <= m2; j++) {
            if(i == inorder[j]){
                break;
            }
            count ++ ;
        }
        if( n1 + 1 <= n1 + count){
            treeNode.left = buildTree(preorder,inorder, n1 + 1,n1 + count,m1,m1 + count - 1);
        }

        if( n1 + count + 1   <= n2){
            treeNode.right = buildTree(preorder,inorder,n1 + count + 1   ,n2,m1 + count + 1  ,m2);
        }
        return treeNode;
    }

    public static void main(String[] args) {
        LeetCode105 leetCode105 = new LeetCode105();
        TreeNode treeNode = leetCode105.buildTree(new int[]{1, 2}, new int[]{2, 1});
        System.out.println(treeNode);
    }
}
