class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int XOR1=0;
        int N=nums.size();
        for (int i=0;i<nums.size();i++){
           XOR1=XOR1^nums[i];
        }
        int XOR2=0;
        for (int j=0;j<=N;j++){
            XOR2=XOR2^j;
        }
        return XOR1^XOR2;
    }
};