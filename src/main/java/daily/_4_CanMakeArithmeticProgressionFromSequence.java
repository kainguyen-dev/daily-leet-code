package daily;

import java.util.Arrays;

public class _4_CanMakeArithmeticProgressionFromSequence {

    // https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/

    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);

        int dist = arr[1] - arr[0];

        for (int i = 1; i < arr.length - 1; i++) {
            int curDist = arr[i + 1] - arr[i];
            if (curDist != dist) return false;
        }

        return true;
    }

    public static void main(String[] args) {
    }

}
