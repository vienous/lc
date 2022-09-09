package com.vin;

import com.vin.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class T {
    public static boolean canBeEqual(int[] target, int[] arr) {
        for (int i = 0; i < target.length; i++){
            if (target[i] != arr[i]){
                int index = search(arr, i, target[i]);
                if (index == -1){
                    return false;
                }else {
                    swap(arr, i, index);
                    Utils.printArray(arr);
                }
            }
        }
        return true;
    }

    public static int search(int[] arr, int index, int k){
        for (int i = index + 1;i<arr.length;i ++){
            if (arr[i] == k){
                return i;
            }
        }
        return -1;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        ff(root,list);
        return list;
    }

    private void ff(TreeNode root, List<Integer> list){
        if (root.left != null){
            ff(root.left, list);
        }
        list.add(root.val);
        if (root.right != null){
            ff(root.right, list);
        }
    }


    public int maxProduct(int[] nums) {
       int m1 = nums[0];
       int m2 = nums[1];
       for (int i = 2; i< nums.length;i++){
           if (nums[i] > Math.min(m1,m2)){
               m1 = Math.max(m1,m2);
               m2 = nums[i];
           }
       }
       return (m1-1)*(m2-1);
    }

    public static void swap(int[] arr, int b, int s){
        while (b < s){
            int temp = arr[b];
            arr[b] = arr[s];
            arr[s] = temp;
            b++;
            s--;
        }
    }

    public static void main(String[] args) {
        int[] target = {1,2,3,4};
        int[] arr = {2,4,1,3};
        System.out.println(canBeEqual(target, arr));
    }
}
