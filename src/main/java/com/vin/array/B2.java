package com.vin.array;

import com.vin.array.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class B2 {
    public static int widthOfBinaryTree(TreeNode root) {
        int res = 1;
        List<TreeNode> list = new ArrayList<>();
        root.val = 1;
        list.add(root);
        while (list.size()>0) {
            List<TreeNode> temp = new ArrayList<>();
            for (TreeNode treeNode : list){
                if (treeNode.left != null){
                    treeNode.left.val = treeNode.val *2;
                    temp.add(treeNode.left);
                }
                if (treeNode.right != null){
                    treeNode.right.val = treeNode.val *2+1;
                    temp.add(treeNode.right);
                }
            }
            res = Math.max(res, list.get(list.size()-1).val - list.get(0).val+1);
            list = temp;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root3 = new TreeNode(3);
        TreeNode root2 = new TreeNode(2);

        root3.left = new TreeNode(5);
        root.left = root3;
        root.right = root2;

        System.out.println(widthOfBinaryTree(root));
    }
}
