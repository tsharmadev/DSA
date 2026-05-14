class Solution {
    /* Function to get the single 
    number in the given array */
    public int singleNumber(int[] nums) {
        // Variable to store size of array
        int n = nums.length;
        
        // Variable to store the ans
        int ans = 0;
        
        // Checking every bit position
        for (int bitIndex = 0; bitIndex < 32; bitIndex++) {
            
            /* Variable to count number of 
            set bits in bitIndex position */
            int count = 0;
            
            // Traversing all elements 
            for (int i = 0; i < n; i++) {
                
                /* Counting elements having set
                bits at bitIndex position */
                if ((nums[i] & (1 << bitIndex)) != 0) {
                    count++;
                }
            }
            
            // Updating bits in answer
            if (count % 3 != 0) {
                ans |= (1 << bitIndex);
            }
        }
        
        return ans;
    }
}