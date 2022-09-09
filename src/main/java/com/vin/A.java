package com.vin;

import com.vin.model.TreeNode;

import java.util.*;

public class A {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        if (nums.length == 2) {
            return nums[0] == nums[1] ? 1 : 2;
        }
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                nums[i + 1] = nums[j];
                i++;
            }
            j++;
        }
        return i + 1;
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

//    public static void main(String[] args) {
////        int[] array = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
////        int k = removeDuplicates(array);
////        System.out.println(k);
//        int[][] rides = {{1, 6, 1}, {3, 10, 2}, {10, 12, 3}, {11, 12, 2}, {12, 15, 2}, {13, 18, 1}};
//        maxTaxiEarnings(20, rides);
//    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return new int[]{0};
        }
        int[] inDegrees = new int[numCourses];
        for (int[] p : prerequisites) {
            inDegrees[p[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }
        for (int n : inDegrees) {
            if (n == 0) {
                queue.offer(n);
            }
        }
        int[] res = new int[numCourses];
        int count = 0;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            res[count++] = num;
            for (int[] p : prerequisites) {
                if (p[1] == num) {
                    inDegrees[p[0]]--;
                    if (inDegrees[p[0]] == 0) {
                        queue.offer(p[0]);
                    }
                }
            }
        }
        if (count == numCourses) {
            return res;
        }
        return new int[0];
    }

    public static void qSort(int[][] arr, int start, int end) {
        if (start > end) {
            return;
        }
        int i = start;
        int j = end;
        int[] base = arr[start];
        while (start < end) {
            while (start < end && arr[end][1] > base[1]) {
                end--;
            }
            arr[start] = arr[end];
            while (start < end && arr[start][1] <= base[1]) {
                start++;
            }
            arr[end] = arr[start];
        }
        arr[start] = base;
        qSort(arr, i, start - 1);
        qSort(arr, start + 1, j);
    }

    public static long maxTaxiEarnings(int n, int[][] rides) {
        if (rides.length == 1) {
            return rides[0][1] - rides[0][0] + rides[0][2];
        }
        qSort(rides, 0, rides.length - 1);
        long[] dp = new long[n + 1];
        int[] money = new int[rides.length];
        for (int i = 0; i < rides.length; i++) {
            money[i] = rides[i][1] - rides[i][0] + rides[i][2];
        }
        int index = 0;
        for (int i = 1; i <= n; i++) {
            Utils.fg(i);
            dp[i] = dp[i - 1];
            while (index < rides.length && rides[index][1] <= i) {
                dp[i] = Math.max(dp[i], dp[rides[index][0]] + money[index]);
                Utils.printArray(dp);
                index++;
            }
        }
        return dp[n];
    }

    public static void sort(int[][] rides) {
        for (int i = 0; i < rides.length - 1; i++) {
            for (int j = 1; j < rides.length; j++) {
                if (rides[j - 1][1] > rides[j][1]) {
                    int[] temp = rides[j - 1];
                    rides[j - 1] = rides[j];
                    rides[j] = temp;
                }
            }
        }
    }

    public static void testLargestVariance() {
        String s = "aababbb";
        a(s);
    }

    public static void testFindClosestElements() {
        int[][] rides = {{2, 3, 6}, {8, 9, 8}, {5, 9, 7}, {8, 9, 1}, {2, 9, 2}, {9, 10, 6}, {7, 10, 10}, {6, 7, 9}, {4, 9, 7}, {2, 3, 1}};
        maxTaxiEarnings(10, rides);
    }


    public static int a(String str) {

        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            Map<Character, Integer> map = new HashMap<>();
            map.put(str.charAt(i), 1);
            for (int j = i + 1; j < str.length(); j++) {
                map.putIfAbsent(str.charAt(j), 0);
                map.put(str.charAt(j), map.get(str.charAt(j)) + 1);
                int temp = getMax(new ArrayList<>(map.values()));
                if (temp > max) {
                    max = temp;
                }
            }
//            map.put(str.charAt(i),map.get(str.charAt(i))-1);
        }
        return max;
    }


    public int[] aa(int[] nums){
        int[] res = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            res[i] = sum;
        }
        return res;
    }

    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i: nums){
            sum +=i;
        }
        int r = 0;
        for (int i = 0; i <nums.length ; i++) {
            int left = sum - nums[i] - r;
            if (r == left){
                return i;
            }else {
                r+=nums[i];
            }
        }
        return -1;

    }

    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> result = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return result;
    }
    public String dfs(TreeNode node) {
        if (node == null) return "";
        String key = node.val + "," + dfs(node.left) + "," + dfs(node.right);
        map.putIfAbsent(key, 0);
        if (map.get(key) == 1) result.add(node);
        map.put(key, map.get(key) + 1);
        return key;
    }


    public static int getMax(List<Integer> list) {
        if (list.size() == 1) {
            return 0;
        }
        Collections.sort(list);
        return list.get(list.size() - 1) - list.get(0);
    }

    public static void main(String[] args) {
//        testFindClosestElements();
        testLargestVariance();
    }


    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        if (x < arr[0]) {
            for (int i = 0; i < k; i++) {
                list.add(arr[i]);
            }
            return list;
        } else if (x > arr[arr.length - 1]) {
            for (int i = arr.length - k; i < arr.length; i++) {
                list.add(arr[i]);
            }
            return list;
        } else {
            int min = 0;
            for (int i = 0; i < k; i++) {
                min += Math.abs(arr[i] - x);
            }
            int index = k;
            for (int i = k; i < arr.length; i++) {
                int temp = min + Math.abs(arr[i] - x) - Math.abs(arr[i - k] - x);
                if (temp > min) {
                    break;
                }
                if (temp < min) {
                    min = temp;
                    index = i + 1;
                }
            }
            for (int i = index - k; i < index; i++) {
                list.add(arr[i]);
            }
            return list;
        }
    }

//    public static void main(String[] args) {
//        int[] array = {3,5,8,10};
//        List<Integer> list = findClosestElements (array,2,15);
//    }

}
