import org.junit.jupiter.api.Test;

import java.util.Arrays;

class _10_EqualRowColumnPairsTest {

    @Test
    void equalPairs_testCase1() {
        int[][] arr = new int[][]{{3, 2, 1}, {1, 7, 6}, {2, 7, 7}};
        int res1 = _10_EqualRowColumnPairs.equalPairs(arr);
        assert res1 == 1;
    }

    @Test
    void equalPairs_testCase2() {
        int[][] arr = new int[][]{
            {3, 1, 2, 2},
            {1, 4, 4, 5},
            {2, 4, 2, 2},
            {2, 4, 2, 2}
        };
        int res1 = _10_EqualRowColumnPairs.equalPairs(arr);
        System.out.println(res1);
        assert res1 == 3;
    }

    @Test
    void name() {
        int[] arr1 = new int[]{1, 2, 3};
        int[] arr2 = new int[]{1, 2, 3};
        assert Arrays.equals(arr2, arr1);
    }
}
