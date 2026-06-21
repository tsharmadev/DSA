class Solution {
    public int findNthDigit(int n) {
        long len = 1;
        long count = 9; 
        long start = 1; 
        while (n > len * count) {
            n -= len * count;
            len++;
            count *= 10;
            start *= 10;
        }
        long number = start + (n - 1) / len;
        String numStr = Long.toString(number);
        int digitIndex = (int)((n - 1) % len);
        
        return numStr.charAt(digitIndex) - '0';
    }
}