import java.util.HashMap;
import java.util.Map;

public class _10_EqualRowColumnPairs {

    public static int equalPairs(int[][] grid) {
        Map<String, Integer> map = new HashMap<>();

        int N = grid.length;

        // Scan all rows
        for (int[] ints : grid) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < N; j++)
                sb.append(ints[j]).append("_");
            map.compute(sb.toString(), (k, v) -> v == null ? 1 : v + 1);
        }

        int res = 0;
        // Scan all cols
        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            for (int[] ints : grid) {
                sb.append(ints[i]).append("_");
            }
            if (map.containsKey(sb.toString())) {
                res += map.get(sb.toString());
            }
        }
        return res;
    }

}
