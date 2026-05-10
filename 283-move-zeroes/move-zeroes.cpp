class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int n = nums.size();
        if (n == 0) return;  // Handle empty array case

        int j = -1;  // Initialize to -1 (no zero found yet)

        // Find the first zero
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }

        // If no zero found, return early
        if (j == -1) return;

        // Move non-zero elements to the front
        for (int i = j + 1; i < n; i++) {
            if (nums[i] != 0) {
                swap(nums[i], nums[j]);
                j++;
            }
        }
    }
};