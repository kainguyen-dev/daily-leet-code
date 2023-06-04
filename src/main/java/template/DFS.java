package template;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DFS {
    static class GridDFS {
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] matrix;
        boolean[][] seen;
        int height, length;

        public GridDFS(int[][] matrix) {
            this.matrix = matrix;
            this.length = matrix[0].length;
            this.height = matrix.length;
            this.seen = new boolean[height][length];
        }

        public List<int[]> getNeighbours(int[][] matrix, int[] node) {
            List<int[]> result = new ArrayList<>();
            for (int[] direction : directions) {
                int row = node[0] + direction[0];
                int col = node[1] + direction[1];
                if (col >= 0 && col < length && row >= 0 && row < height && matrix[row][col] == 1) {
                    result.add(new int[]{row, col});
                }
            }
            return result;
        }

        public void dfs() {
            int nCluster = 0;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < length; j++) {
                    int[] curNode = new int[]{i, j};
                    // If node is not visited and is island
                    if (!seen[i][j] && matrix[i][j] == 1) {
                        Stack<int[]> stack = new Stack<>();
                        stack.add(curNode);
                        seen[i][j] = true;

                        while (!stack.isEmpty()) {
                            int[] popNode = stack.pop();
                            System.out.print("Get [" + popNode[0] + " " + popNode[1] + "] ");
                            for (int[] node : getNeighbours(matrix, popNode)) {
                                if (!seen[node[0]][node[1]]) {
                                    stack.push(node);
                                    seen[node[0]][node[1]] = true;
                                }
                            }
                        }
                        System.out.println();
                        nCluster++;
                    }
                }
            }
            System.out.println("Total cluster " + nCluster);
        }

        public static void main(String[] args) {
            int[][] matrix = new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 1, 0, 1}
            };
            GridDFS dfs = new GridDFS(matrix);
            dfs.dfs();
        }
    }


    static class AdjListDFS {
        int vertices;
        List<List<Integer>> adjLists;
        ArrayList<Boolean> seen;

        public AdjListDFS(int vertices) {
            this.vertices = vertices;
            adjLists = new LinkedList<>();
            seen = new ArrayList<>();
            for (int i = 0; i < vertices; i++) {
                adjLists.add(new LinkedList<>());
                seen.add(false);
            }
        }

        public void addEdge(int source, int dest) {
            this.adjLists.get(source).add(dest);
        }

        public void dfsNode(int vertx) {
            Stack<Integer> stack = new Stack<>();
            seen.set(vertx, true);
            stack.add(vertx);

            while (!stack.isEmpty()) {
                int pop = stack.pop();

                System.out.print(pop + " ");

                List<Integer> neighbors = adjLists.get(pop);

                for (Integer neighbor : neighbors) {
                    if (!seen.get(neighbor)) {
                        seen.set(neighbor, true);
                        stack.push(neighbor);
                    }
                }
            }
        }

        public void dfs() {
            int nCluster = 0;
            for (int i = 0; i < vertices; i++) {
                if (!seen.get(i)) {
                    dfsNode(i);
                    nCluster++;
                    System.out.println();
                }
            }
            System.out.println("Total cluster: " + nCluster);
        }

        public static void main(String[] args) {
            AdjListDFS dfs = new AdjListDFS(6);
            dfs.addEdge(0, 1);
            dfs.addEdge(1, 2);
            dfs.addEdge(0, 3);

            dfs.addEdge(4, 5);
            dfs.dfs();
        }
    }

}
