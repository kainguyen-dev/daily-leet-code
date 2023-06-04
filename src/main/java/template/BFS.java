package template;

import java.util.*;

public class BFS {

    static class GridBFS {
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] matrix;
        boolean[][] seen;
        int height, length;

        public GridBFS(int[][] matrix) {
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

        public void bfs() {
            int nCluster = 0;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < length; j++) {
                    int[] curNode = new int[]{i, j};
                    // If node is not visited and is island
                    if (!seen[i][j] && matrix[i][j] == 1) {
                        Queue<int[]> queue = new ArrayDeque<>();
                        queue.add(curNode);
                        seen[i][j] = true;

                        while (!queue.isEmpty()) {
                            int[] popNode = queue.poll();
                            System.out.print("Get [" + popNode[0] + " " + popNode[1] + "] ");
                            for (int[] node : getNeighbours(matrix, popNode)) {
                                if (!seen[node[0]][node[1]]) {
                                    queue.offer(node);
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
            GridBFS bfs = new GridBFS(matrix);
            bfs.bfs();
        }
    }


    static class AdjListBFS {

        int vertices;
        List<List<Integer>> adjLists;
        ArrayList<Boolean> seen;

        public AdjListBFS(int vertices) {
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

        public void bfsNode(int vertex) {
            Queue<Integer> queue = new ArrayDeque<>();
            seen.set(vertex, true);
            queue.offer(vertex);

            while (!queue.isEmpty()) {
                int pop = queue.poll();

                System.out.print(pop + " ");

                List<Integer> neighbors = adjLists.get(pop);
                for (int neighbor : neighbors) {
                    if (!seen.get(neighbor)) {
                        seen.set(neighbor, true);
                        queue.offer(neighbor);
                    }
                }
            }
        }

        public void bfs() {
            int nCluster = 0;
            for (int i = 0; i < vertices; i++) {
                if (!seen.get(i)) {
                    bfsNode(i);
                    nCluster++;
                    System.out.println();
                }
            }
            System.out.println("Total cluster: " + nCluster);
        }

        public static void main(String[] args) {
            AdjListBFS bfs = new AdjListBFS(6);
            bfs.addEdge(0, 1);
            bfs.addEdge(1, 2);
            bfs.addEdge(0, 3);

            bfs.addEdge(4, 5);
            bfs.bfs();
        }
    }

}
