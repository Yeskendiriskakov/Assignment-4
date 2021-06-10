package com.company;


  // Definition for a binary tree node.
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution {

    int calcHeight(TreeNode cur){
        if(cur == null){
            return 0;
        }
        return Math.max(calcHeight(cur.left), calcHeight(cur.right)) + 1;
    }

    int getSum(TreeNode cur, int height, int mxheight){
        if(cur == null){
            return 0;
        }
        if(height == mxheight){
            return cur.val;
        }
        return getSum(cur.left, height + 1, mxheight) + getSum(cur.right, height + 1, mxheight);
    }
    public int deepestLeavesSum(TreeNode root) {
        int height = calcHeight(root) - 1;
        return getSum(root, 0, height);
    }
}
