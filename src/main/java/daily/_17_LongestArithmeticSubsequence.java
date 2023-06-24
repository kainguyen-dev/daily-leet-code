package daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _17_LongestArithmeticSubsequence {


    // https://leetcode.com/problems/longest-arithmetic-subsequence/description/

    static public int longestArithSeqLength(int[] nums) {
        int maxLen = 0;
        List<Map<Integer, Integer>> dp = new ArrayList<>(nums.length);
        for (int right = 0; right < nums.length; right++) {
            dp.add(new HashMap<>());

            for (int left = 0; left < right; left++) {
                int diff = nums[right] - nums[left];
                dp.get(right).put(diff, dp.get(left).getOrDefault(diff, 1) + 1);
                maxLen = Math.max(maxLen, dp.get(right).get(diff));
            }

        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestArithSeqLength(new int[]{20, 1, 15, 3, 10, 5, 8}));
    }

}
