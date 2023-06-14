import java.util.ArrayList;
import java.util.List;

public class _9_SummaryRanges {

    public static List<String> summaryRanges(int[] nums) {

        List<String> result = new ArrayList<>();

        int endIndex = 0;
        while (endIndex < nums.length) {
            int startIndex = endIndex;
            while (true) {
                if (endIndex == nums.length - 1 || (long) nums[endIndex + 1] - (long) nums[endIndex] > 1) {
                    break;
                } else {
                    endIndex++;
                }
            }

            if (startIndex == endIndex) {
                result.add(String.valueOf(nums[startIndex]));
            } else {
                String str = String.format("%d->%d", nums[startIndex], nums[endIndex]);
                result.add(str);
            }
            endIndex++;
        }

        return result;
    }

}
