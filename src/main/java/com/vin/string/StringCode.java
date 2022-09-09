package com.vin.string;

import java.util.ArrayList;
import java.util.List;

public class StringCode {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs("", n, n, result);
        return result;
    }

    private static void dfs(String s, int left, int right, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(s);
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            dfs(s + "(", left - 1, right, result);
        }
        if (right > 0) {
            dfs(s + ")", left, right - 1, result);
        }
    }

    public static void main(String[] args) {
        List<String> r = generateParenthesis(3);
        for (String s : r){
            System.out.println(s);
        }

    }
}
