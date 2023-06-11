public class _7_MaximumValueGivenIndexBoundedArray {


    // https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/

    /**
     * Formula of sequence of number from a to b
     * <p>
     * S = N / 2 * ( 2*a + ( b - 1 ) )
     * <p>
     * S = N / 2 * ( 2*a + ( b - 1 ) ) + ( index - value + 1)
     */

    private long getSum(int index, int value, int n) {
        long count = 0;

        // On index's left:
        // If value > index, there are index + 1 numbers in the arithmetic sequence:
        // [value - index, ..., value - 1, value].
        // Otherwise, there are value numbers in the arithmetic sequence:
        // [1, 2, ..., value - 1, value], plus a sequence of length (index - value + 1) of 1s.
        if (value > index) {
            count += (long) (value + value - index) * (index + 1) / 2;
        } else {
            count += (long) (value + 1) * value / 2 + index - value + 1;
        }
        ;
        // On index's right:
        // If value >= n - index, there are n - index numbers in the arithmetic sequence:
        // [value, value - 1, ..., value - n + 1 + index].
        // Otherwise, there are value numbers in the arithmetic sequence:
        // [value, value - 1, ..., 1], plus a sequence of length (n - index - value) of 1s.
        if (value >= n - index) {
            count += (long) (value + value - n + 1 + index) * (n - index) / 2;
        } else {
            count += (long) (value + 1) * value / 2 + n - index - value;
        }

        return count - value;

    }

    public int maxValue(int n, int index, int maxSum) {
        int left = 1, right = maxSum;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (getSum(index, mid, n) <= maxSum) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {

    }
}
