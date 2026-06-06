class Solution {
    public List<List<Integer>> combinationSum3(int k,int n) {
        
       
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> curr=new ArrayList<>(); 
        solve(1,k,n,0,ans,curr);
        return ans;

    }
   public void solve (int num,int k,int n,int sum,List<List<Integer>>ans, List<Integer>curr){
    if((sum==n)&&(curr.size()==k)){
        ans.add(new ArrayList<>(curr));
        return;
    }
    if ((sum>n)||(curr.size()>k) ){
        return;
    }
    if (num>9){
        return;
    }
    curr.add(num);
    solve(num+1,k,n,sum+num,ans,curr);
    curr.remove(curr.size()-1);
    solve(num+1,k,n,sum,ans,curr);

   }
    
}