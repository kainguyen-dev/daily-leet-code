public class _6_CountNegativeNumbersInSortedMatrix {

    public int countNegatives(int[][] grid) {

        int ans = 0;

        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                if (ints[j] < 0) ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
