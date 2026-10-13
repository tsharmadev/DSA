class Solution {
    
    private int[] delRow = {-1, 0, 1, 0};
    private int[] delCol = {0, 1, 0, -1};

    private boolean isValid(int i, int j, 
                            int n, int m) {
        
        if(i < 0 || i >= n) return false;
        if(j < 0 || j >= m) return false;
        return true;
    }
    
    public int orangesRotting(int[][] grid) {
        int count=0;
        int total=0;
        int time=0;
        Queue <int []>q =new LinkedList<>();
      int m=grid.length;
      int n=grid[0].length;
      for (int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if (grid[i][j]!=0){
            total++;
            }
            if (grid[i][j]==2){
                q.add(new int[]{i,j});
            }
        }
      }
      while (!q.isEmpty()){

        int size=q.size();
        count+=size;
        for (int i=0;i<size;i++){
        int cell[]=q.poll();
        int r=cell[0];
        int c=cell[1];
        for(int j=0;j<4;j++){
            int nr=delRow[j]+r;
            int nc=delCol[j]+c;

            if (isValid(nr,nc,m,n)&&(grid[nr][nc]==1)){
                grid[nr][nc]=2;
                q.add(new int[]{nr,nc});
            }
        }

        }
        if(!q.isEmpty()) time++;
        
      }
      if(total==count) return time;
      return -1;

    }

}


