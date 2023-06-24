package daily;

import java.util.*;

public class _1_DetonateTheMaximumBombs {

    // https://leetcode.com/problems/detonate-the-maximum-bombs/

    static public int maximumDetonation(int[][] bombs) {
        int max = Integer.MIN_VALUE;
        for (int[] bomb : bombs) {
            int maxBomb = bfs(bombs, bomb);
            max = Math.max(maxBomb, max);
        }
        return max;
    }


    static public int bfs(int[][] bombs, int[] bomb) {
        Map<int[], Boolean> visited = new HashMap<>();
        Stack<int[]> stack = new Stack<>();
        visited.put(bomb, true);
        stack.push(bomb);

        int numberDetonated = 0;
        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            numberDetonated++;
            for (int[] nearBomb : inRangeDetonated(bombs, visited, pop)) {
                visited.put(nearBomb, true);
                stack.push(nearBomb);
            }
        }
        return numberDetonated;
    }

    static public List<int[]> inRangeDetonated(int[][] bombs, Map<int[], Boolean> visited, int[] cur) {
        List<int[]> result = new ArrayList<>();

        for (int[] bomb : bombs) {
            int bombRadius = cur[2];
            double distance = distance(cur[0], cur[1], bomb[0], bomb[1]);
            if (!visited.getOrDefault(bomb, false) && bombRadius >= distance) {
                result.add(bomb);
            }
        }
        return result;
    }

    static double distance(int x1, int y1, int x2, int y2) {
        int xDiff = x1 - x2;
        int yDiff = y1 - y2;
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }


    public static void main(String[] args) {
        int[][] arr = new int[][]{
            {2, 1, 3}, {6, 1, 4}
        };
        int res = maximumDetonation(arr);
        System.out.println(res); // 2

//        arr = new int[][]{
//            {1, 1, 5}, {10, 10, 5}
//        };
//        res = maximumDetonation(arr);
//        System.out.println(res); // 1
//
//
//        arr = new int[][]{{1, 2, 3}, {2, 3, 1}, {3, 4, 2}, {4, 5, 3}, {5, 6, 4}};
//        res = maximumDetonation(arr);
//        System.out.println(res); // 5
//
//
//        arr = new int[][]{{1, 1, 100000}, {100000, 100000, 1}};
//        res = maximumDetonation(arr);
//        System.out.println(res); // 2

        arr = new int[][] {{44,7589,1681},{33370,50102,5108},{87342,80018,5561},{7302,81208,7932},{28829,67258,7910},{56134,891,4200},{36386,15577,1926},{58216,74639,2925},{24955,28859,5425},{37798,93980,3228},{78969,68755,8930},{30984,20506,3816},{4570,58489,6478},{97831,62423,5656},{30760,66708,4612},{10334,41619,1336},{19056,57064,1411},{74910,16480,5054},{52369,44514,4230},{57732,94661,475},{87320,89508,9957},{70058,79814,2380},{21873,80294,2769},{19846,55615,5466},{22458,54582,2952},{91886,10210,2942},{24638,10649,8165},{61612,41,2245},{74608,99732,5893},{65280,4168,1165},{99805,61100,6439},{71056,88631,1714},{70513,27349,9047},{2513,48746,1105},{29040,91118,7201},{19707,14260,8799}};
        res = maximumDetonation(arr);
        System.out.println(res); // 3
    }

}
