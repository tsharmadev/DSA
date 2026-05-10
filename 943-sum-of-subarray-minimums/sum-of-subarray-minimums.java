class Solution {

    public int[] find_nse(int[] arr) {

        int n = arr.length;
        int[] ans1 = new int[n];
        Stack<Integer> st1 = new Stack<>();

        for(int i = n - 1; i >= 0; i--) {

            while(!st1.isEmpty() && arr[i] <= arr[st1.peek()]) {
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

    public int[] find_pse(int[] arr) {

        int n = arr.length;
        int[] ans2 = new int[n];
        Stack<Integer> st2 = new Stack<>();

        for(int i = 0; i < n; i++) {

            while(!st2.isEmpty() && arr[i] < arr[st2.peek()]) {
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

    public int sumSubarrayMins(int[] arr) {

        int[] nse = find_nse(arr);
        int[] pse = find_pse(arr);

        int n = arr.length;
        int mod = (int)1e9 + 7;

        int sum = 0;

        for(int i = 0; i < n; i++) {

            int left = i - pse[i];
            int right = nse[i] - i;

            long freq = 1L * left * right;

            int val = (int)((freq * arr[i]) % mod);

            sum = (sum + val) % mod;
        }

        return sum;
    }
}