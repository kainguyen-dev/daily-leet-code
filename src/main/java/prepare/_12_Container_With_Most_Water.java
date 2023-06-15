package prepare;

public class _12_Container_With_Most_Water {

    // https://leetcode.com/problems/container-with-most-water/description/

    public int maxArea(int[] height) {

        // Intuitive:
        // using two pointer, try to update by shift to the smallest one, because we want to find a bigger wall

        int left = 0;
        int right = height.length - 1;
        int maxArea = Integer.MIN_VALUE;

        for (int i = 0; i < height.length; i++) {
            int area = Math.min(height[left], height[right]) * (height.length - i - 1);
            maxArea = Math.max(maxArea, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;

    }

}
