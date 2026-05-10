class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int n = nums.size();
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            if (nums[left] == val) {
                swap(nums[left], nums[right]);
                right--;  // Move right backward (ignore swapped val)
            } else {
                left++;   // Move left forward (keep non-val)
            }
        }
        return left;  // All elements before left are non-val
    }
};

//THINK WHY IT WAS WRONG

// class Solution {
// public:
//     int removeElement(vector<int>& nums, int val) {
//         int n=nums.size();
//         int left=0;
//         int right=n-1;

//         while(left<right){
//             if(nums[left]!=val){
//                 left++;
//             }
//             if(nums[right]==val){
//                 right--;
//             }
//             swap(nums[left],nums[right]);
//         }
//         return left;
    
        
//     }
// };