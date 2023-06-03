import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _2_TimeNeededToInformAllEmployees {

    // https://leetcode.com/problems/time-needed-to-inform-all-employees/

    /**
     * BFS
     */
    static public int numOfMinutesBFS(int n, int headID, int[] manager, int[] informTime) {
        int maxTime = Integer.MIN_VALUE;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) adjList.get(manager[i]).add(i);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{headID, informTime[headID]});

        while (!queue.isEmpty()) {
            int[] pop = queue.remove();
            int parent = pop[0];
            int time = pop[1];
            maxTime = Math.max(maxTime, time);

            for (int adjacent : adjList.get(parent)) {
                queue.add(new int[]{adjacent, time + informTime[adjacent]});
            }
        }
        return maxTime;
    }


    /**
     * DFS
     */
    static public int numOfMinutesDFS(int n, int headID, int[] manager, int[] informTime) {
        int maxTime = Integer.MIN_VALUE;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) adjList.get(manager[i]).add(i);
        }

        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{headID, informTime[headID]});

        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            int parent = pop[0];
            int time = pop[1];
            maxTime = Math.max(maxTime, time);

            for (int adjacent : adjList.get(parent)) {
                stack.add(new int[]{adjacent, time + informTime[adjacent]});
            }
        }
        return maxTime;
    }

    public static void main(String[] args) {

        int res;
        res = numOfMinutesBFS(15, 0,
            new int[]{-1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6},
            new int[]{1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0});

        System.out.println(res); // 3

        res = numOfMinutesBFS(1, 0,
            new int[]{-1},
            new int[]{0});

        System.out.println(res); // 0

        res = numOfMinutesBFS(6, 2,
            new int[]{2, 2, -1, 2, 2, 2},
            new int[]{0, 0, 1, 0, 0, 0});

        System.out.println(res); // 1


        res = numOfMinutesBFS(7, 6,
            new int[]{1, 2, 3, 4, 5, 6, -1},
            new int[]{0, 6, 5, 4, 3, 2, 1});
        System.out.println(res); // 1

    }

}
