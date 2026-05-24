class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
       int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        int count = 1;
        int limit = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= limit) {
                count++;
                limit = intervals[i][1];
            }
        }
        return n-count; 
    }
}