class Solution {

    private boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }

    private void bfs(int i, int j, boolean[][] vis, char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{i, j});
        vis[i][j] = true;

        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        while (!q.isEmpty()) {

            int[] cell = q.poll();

            int row = cell[0];
            int col = cell[1];

            for (int k = 0; k < 4; k++) {

                int newRow = row + dRow[k];
                int newCol = col + dCol[k];

                if (isValid(newRow, newCol, n, m)
                        && grid[newRow][newCol] == '1'
                        && !vis[newRow][newCol]) {

                    vis[newRow][newCol] = true;
                    q.add(new int[]{newRow, newCol});
                }
            }
        }
    }

    public int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (!vis[i][j] && grid[i][j] == '1') {
                    count++;
                    bfs(i, j, vis, grid);
                }
            }
        }

        return count;
    }
}