package prepare;

public class _2_SortColors {

    // https://leetcode.com/problems/sort-colors/

    public void sortColors(int[] nums) {
        int pivot = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, pivot, i);
                pivot++;
            }
        }

        pivot = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 2) {
                swap(nums, pivot, i);
                pivot--;
            }
        }
    }

    void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
