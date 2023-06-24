package daily;

import java.util.Arrays;

public class _14_KRadiusSubarrayAverages {

    // https://leetcode.com/problems/k-radius-subarray-averages/

    public int[] getAverages(int[] nums, int k) {
        if (k == 0)
            return nums;

        int n = nums.length;
        int[] averages = new int[n];
        Arrays.fill(averages, -1);

        // Case
        // Input: nums = [8], k = 100000
        // Output: [-1]
        if (2 * k + 1 > n) return averages;

        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        for (int i = k; i < (n - k); i++) {
            int left = i - k;
            int right = i + k;
            long subArraySum = prefix[right + 1] - prefix[left];
            int average = (int) (subArraySum / (2 * k + 1));
            averages[i] = average;
        }
        return averages;
    }

    public static void main(String[] args) {
    }
}
