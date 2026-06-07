class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
       List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums); 
        helper(nums,0,nums.length,ans,list);
        return ans;
        
    }
    public  void helper(int[] nums,int index,int n,List<List<Integer>> ans, List<Integer> list ){
        if(index==n){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        helper(nums,index+1,n,ans,list);
        list.remove(list.size()-1);
        int next = index + 1;
while(next < n && nums[next] ==nums[index])
{
    next++;
}
        helper(nums,next,n,ans,list);

         
    }
}