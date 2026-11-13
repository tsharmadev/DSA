class Solution {

   int find_peak(int[][]mat,int col){  
    int m = mat.length;
    int index = -1;
    int peak = Integer.MIN_VALUE;

    for(int i = 0; i < m; i++) {
       if(mat[i][col] > peak){
        peak = mat[i][col];
        index = i;
       }
    }
    return index;
   }

   public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int low = 0;
        int high = n - 1;

        while(low <= high){
            int mid = (low + high) / 2;
            int row_ind = find_peak(mat, mid);
            if(n == 1){
                 return new int[]{row_ind, 0};
                }

            if(mid == 0){
                if(mat[row_ind][mid] > mat[row_ind][mid + 1]){
                    return new int[]{row_ind, mid};
                } else {
                    low = mid + 1;
                }
            }
            else if(mid == n - 1){
                if(mat[row_ind][mid] > mat[row_ind][mid - 1]){
                    return new int[]{row_ind, mid};
                } else {
                    high = mid - 1;
                }
            }
            else {
                if(mat[row_ind][mid] > mat[row_ind][mid - 1] &&
                   mat[row_ind][mid] > mat[row_ind][mid + 1]){
                    return new int[]{row_ind, mid};
                }
                else if(mat[row_ind][mid] < mat[row_ind][mid + 1]){
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }

        return new int[]{-1, -1};
    }
}