class Solution {
    public List<List<String>> partition(String s) {
        List <List<String>> ans =new ArrayList<>();
        List <String> curr=new ArrayList<>();
        helper(s,0,ans,curr);
        return ans;
    }

    public void helper(String s,int index,List<List<String>> ans, List<String> curr){
        if(index==s.length()){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(check(s,index,i)){
                curr.add(s.substring(index,i+1));
                helper(s,i+1,ans,curr);
                curr.remove(curr.size()-1);
            }
        }
    }

    public boolean check(String s,int left,int right){
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}