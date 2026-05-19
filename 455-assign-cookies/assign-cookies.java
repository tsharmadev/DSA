class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int sn=g.length;
        int cn=s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int l=0;
        int r=0;
        int cnt=0;
        while (l!=sn && r!= cn){

            if(s[r]>=g[l]){
                cnt++;
                l++;
                r++;
            }
            else{
                r++;
            }
        }
        return cnt;
    }
}
