class Solution {
    public int mySqrt(int x) {
        if (x==0 || x==1){
            return x;
        }
        int low=1;
        int high=x/2;
        int ans=0;
        while (low<=high){
            int middle=low + (high - low) / 2;
            if ((long)middle*middle <= x){
                ans=middle;
                low=middle+1;
            }
            else{
                high=middle-1;
            }
        }
        return ans;
    }
}