package prepare;

public class _8_TrappingRainWater {

    // https://leetcode.com/problems/trapping-rain-water/

    public int trap(int[] height) {

        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int result = 0;
        while (left < right) {
            if (height[left] < height[right]) {

                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    // We can add some water
                    result += (leftMax - height[left]);
                }

                left++;
            } else {

                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    // We can add some water
                    result += (rightMax - height[right]);
                }

                right--;
            }
        }

        return result;
    }
}
