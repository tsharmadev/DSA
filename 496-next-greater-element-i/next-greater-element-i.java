import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int n = nums2.length;
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();

        // Step 1: Find NGE for nums2
        for (int i = n - 1; i >= 0; i--) {

            int currEle = nums2[i];

            while (!st.isEmpty() && st.peek() <= currEle) {
                st.pop();
            }

            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }

            st.push(currEle);
        }

        // Step 2: Store element -> NGE mapping
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(nums2[i], ans[i]);
        }

        // Step 3: Find answers for nums1
        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }
}