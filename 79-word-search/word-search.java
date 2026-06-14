 class Solution {
    public boolean exist(char[][] board, String word) {
        //your code goes here
        int n=word.length();
        int n1=board.length;
        int n2=board[0].length;
        for(int i=0;i<n1;i++){
            for (int j=0;j<n2;j++){
                if(board[i][j]==word.charAt(0)){
                 if (helper( board,word,n,i,j,0,n1,n2)){
                    return true;
                 }          //start from every index
                }
            }
            }
            return false;
        }
        


    public boolean helper(char[][] board,String word,int n,int r,int c,int index,int n1,int n2){
        if(index==n){
            return true;
        }
       
       if((r>=n1)||(r<0)||(c>=n2)||(c<0)){         //if out of boundsss
        return false;
       }
       
       if (board[r][c] != word.charAt(index)) {         //if curr cell doesn't matches return immediately
            return false;
        }
            char ch=board[r][c];
            board[r][c]='#';
        
            
            boolean dfsdown=helper(board,word,n,r-1,c,index+1,n1,n2);
            boolean dfsup=helper(board,word,n,r+1,c,index+1,n1,n2);
            boolean dfsright=helper(board,word,n,r,c+1,index+1,n1,n2);
            boolean dfsleft=helper(board,word,n,r,c-1,index+1,n1,n2);

            board[r][c]=ch;         //restore for backtracking
            return ((dfsdown)||(dfsup)||(dfsleft)||(dfsright));

        }

 }        
        

