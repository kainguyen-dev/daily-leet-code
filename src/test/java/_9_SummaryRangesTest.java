

import daily._9_SummaryRanges;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


public class _9_SummaryRangesTest {

    @Test
    void summaryRanges_testCase1() {
        int[] nums = new int[]{0, 1, 2, 4, 5, 7};
        List<String> result = _9_SummaryRanges.summaryRanges(nums);
        List<String> expect = List.of("0->2", "4->5", "7");
        Assertions.assertArrayEquals(expect.toArray(), result.toArray());
    }


    @Test
    void summaryRanges_testCase2() {
        int[] nums = new int[]{0, 2, 3, 4, 6, 8, 9};
        List<String> result = _9_SummaryRanges.summaryRanges(nums);
        List<String> expect = List.of("0", "2->4", "6", "8->9");
        Assertions.assertArrayEquals(expect.toArray(), result.toArray());
    }

    @Test
    void summaryRanges_testCase3() {
        int[] nums = new int[]{-2147483648, -2147483647, 2147483647};
        List<String> result = _9_SummaryRanges.summaryRanges(nums);
        List<String> expect = List.of("-2147483648->-2147483647", "2147483647");
        Assertions.assertArrayEquals(expect.toArray(), result.toArray());
    }
}
