import java.util.*;

class Solution {

    // Recursive helper function to find combinations
    private void func(int ind, int sum, List<Integer> nums, 
                      int[] candidates, List<List<Integer>> ans) {
        // If the sum is zero, add the current combination to the result
        if (sum == 0) {
            ans.add(new ArrayList<>(nums));
            return;
        }

        // If the sum is negative or we have exhausted the candidates, return
        if (sum < 0 || ind == candidates.length) return; 

        // Include the current candidate
        nums.add(candidates[ind]);

        // Recursively call with updated sum and next index
        func(ind + 1, sum - candidates[ind], nums, candidates, ans);

        // Backtrack by removing the last added candidate
        nums.remove(nums.size() - 1);

        // Skip duplicates: if not picking the current candidate, 
        // ensure the next candidate is different
        for(int i = ind + 1; i < candidates.length; i++) {
            if(candidates[i] != candidates[ind]) {
                func(i, sum, nums, candidates, ans);
                break;
            }
        }
    }

    // Main function to find all unique combinations
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();

        // Sort candidates to handle duplicates
        Arrays.sort(candidates);

        // Start the recursive process
        func(0, target, nums, candidates, ans);
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Sample input
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        // Call the combinationSum2 function
        List<List<Integer>> result = sol.combinationSum2(candidates, target);

        // Output the result
        System.out.println("Combinations are: ");
        for (List<Integer> combination : result) {
            for (int num : combination) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}