import java.util.*;

class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        boolean[][] visited = new boolean[m][n];
        int[][] dist = new int[m][n];

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int row = curr[0];
            int col = curr[1];
            int steps = curr[2];

            dist[row][col] = steps;

            for (int i = 0; i < 4; i++) {

                int nr = row + delRow[i];
                int nc = col + delCol[i];

                if (nr >= 0 && nr < m &&
                    nc >= 0 && nc < n &&
                    !visited[nr][nc]) {

                    visited[nr][nc] = true;

                    q.add(new int[]{nr, nc, steps + 1});
                }
            }
        }

        return dist;
    }
}