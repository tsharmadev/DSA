class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();

        for (char ch : num.toCharArray()) {
            while (!st.isEmpty() && k > 0 && st.peek() > ch) {
                st.pop();
                k--;
            }
            st.push(ch);
        }

        // If k still remains, remove from end
        while (k > 0) {
            st.pop();
            k--;
        }

        // Build result
        StringBuilder result = new StringBuilder();
        while (!st.isEmpty()) {
            result.append(st.pop());
        }

        result.reverse();

        // Remove leading zeros
        while (result.length() > 0 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return result.length() == 0 ? "0" : result.toString();
    }
}