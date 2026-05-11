class Solution {

    public int[] find_nse(int[] nums) {

        int n = nums.length;
        int[] ans1 = new int[n];
        Stack<Integer> st1 = new Stack<>();

        for(int i = n - 1; i >= 0; i--) {

            while(!st1.isEmpty() && nums[i] <= nums[st1.peek()]) {
                st1.pop();
            }

            if(st1.isEmpty()) {
                ans1[i] = n;
            }
            else {
                ans1[i] = st1.peek();
            }

            st1.push(i);
        }

        return ans1;
    }

    public int[] find_pse(int[] nums) {

        int n = nums.length;
        int[] ans2 = new int[n];
        Stack<Integer> st2 = new Stack<>();

        for(int i = 0; i < n; i++) {

            while(!st2.isEmpty() && nums[i] < nums[st2.peek()]) {
                st2.pop();
            }

            if(st2.isEmpty()) {
                ans2[i] = -1;
            }
            else {
                ans2[i] = st2.peek();
            }

            st2.push(i);
        }

        return ans2;
    }

    public int[] find_nge(int[] nums) {

        int n = nums.length;
        int[] ans3 = new int[n];
        Stack<Integer> st3 = new Stack<>();

        for(int i = n - 1; i >= 0; i--) {

            while(!st3.isEmpty() && nums[i] >= nums[st3.peek()]) {
                st3.pop();
            }

            if(st3.isEmpty()) {
                ans3[i] = n;
            }
            else {
                ans3[i] = st3.peek();
            }

            st3.push(i);
        }

        return ans3;
    }

    public int[] find_pge(int[] nums) {

    int n = nums.length;
    int[] ans4 = new int[n];
    Stack<Integer> st4 = new Stack<>();

    for(int i = 0; i < n; i++) {

        while(!st4.isEmpty() && nums[i] > nums[st4.peek()]) {
            st4.pop();
        }

        if(st4.isEmpty()) {
            ans4[i] = -1;
        }
        else {
            ans4[i] = st4.peek();
        }

        st4.push(i);
    }

    return ans4;
}


    public long subArrayRanges(int[] nums) {

        int[] nse = find_nse(nums);
        int[] pse = find_pse(nums);
        int[] nge= find_nge(nums);
        int[] pge =find_pge(nums);

        int n = nums.length;
        long range=0;
        long max=0;
        long min=0;
        for(int i=0;i<n;i++){
           int left=i-pse[i];
           int right=nse[i]-i;
           long freq=left*right*1L;
           long val=freq*nums[i];
           min+=val;
        }

        for(int i=0;i<n;i++){
           int left1=i-pge[i];
           int right1=nge[i]-i;
           long freq=left1*right1*1L;
           long val=freq*nums[i];
           max+=val;
        }
        range=max-min;
        return range;


        
    }
}