package prepare;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _7_NumberOfIsLand {

    // https://leetcode.com/problems/number-of-islands/

    int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<int[]> getNeighbours(char[][] matrix, int[] node) {

        int length = matrix[0].length;
        int height = matrix.length;

        List<int[]> result = new ArrayList<>();
        for (int[] direction : directions) {
            int row = node[0] + direction[0];
            int col = node[1] + direction[1];
            if (col >= 0 && col < length && row >= 0 && row < height && matrix[row][col] == '1') {
                result.add(new int[]{row, col});
            }
        }
        return result;
    }

    public int numIslands(char[][] grid) {

        int ROW = grid.length;
        int COL = grid[0].length;
        boolean[][] seen = new boolean[ROW][COL];
        int numIsland = 0;

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {

                // If node is island and we not see it
                if (!seen[i][j] && grid[i][j] == '1') {
                    int[] cur = new int[]{i, j};
                    Stack<int[]> stack = new Stack<>();
                    stack.push(cur);
                    seen[i][j] = true;

                    while (!stack.isEmpty()) {
                        int[] pop = stack.pop();
                        for (int[] neighbour : getNeighbours(grid, pop)) {
                            if (!seen[neighbour[0]][neighbour[1]]) {
                                stack.push(neighbour);
                                seen[neighbour[0]][neighbour[1]] = true;
                            }
                        }
                    }
                    numIsland++;
                }

            }
        }
        return numIsland;
    }

}
