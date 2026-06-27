class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        map<int,int> mpp;
        for(int i=0;i<nums.size();i++){
            int a=nums[i];
            int more=target-a;

            if(mpp.find(more)!=mpp.end()){
                return {mpp[more],i};         //will return this vector..index of more and i
            }
            mpp[a]=i;
        }
        return {};  //return empty vector if not found
    }
};