class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        int n=candidates.length;
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> curr=new ArrayList<>(); 
        Arrays.sort(candidates);
        solve(0,candidates,target,0,ans,curr,n);
        return ans;

    }
   public void solve (int index,int[]candidates,int k,int sum,List<List<Integer>>ans, List<Integer>curr,int n){
    if(sum==k){
        ans.add(new ArrayList<>(curr));
        return;
    }
    if ((sum>k)|| (index==n)){
        return;
    }
    curr.add(candidates[index]);
    solve(index+1,candidates,k,sum+candidates[index],ans,curr,n);
    curr.remove(curr.size()-1);
    int next = index + 1;
while(next < n && candidates[next] == candidates[index])
{
    next++;
}
    solve(next,candidates,k,sum,ans,curr,n);

   }
    
}