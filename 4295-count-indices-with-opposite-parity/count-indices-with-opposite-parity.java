class Solution {
    public int[] countOppositeParity(int[] nums) {
        int n=nums.length;
        for (int i=0;i<n;i++){
            int score=0;
            for(int j=i+1;j<n;j++){
                if(((nums[i]%2==0)&&(nums[j]%2!=0)) || ((nums[i]%2!=0)&&(nums[j]%2==0))){
                    score++;
                }
            }
            nums[i]=score;
        }
        return nums;
    }
}