class Solution {
    public int characterReplacement(String s, int k) {
    int maxLen=0;
        int maxFreq=0;
        int l=0;
        int r=0;
        int n=s.length();
        int[] hash = new int[26];
        while(r<n){
            hash[s.charAt(r)-'A']++;
            maxFreq=Math.max(maxFreq,hash[s.charAt(r)-'A']);
            while((r-l+1)-maxFreq>k){
                hash[s.charAt(l)-'A']--;
                l++;
            }
            maxLen=Math.max((r-l+1),maxLen);
            r++;

        }
        return maxLen;
    }
}