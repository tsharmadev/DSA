class Solution {
    public int divide(int dividend, int divisor) {
        boolean sign=true;
        if(dividend == divisor) return 1;
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if(divisor == 1) return dividend;
        if (dividend>=0 && divisor <0){
           sign=false;
        }
        if (dividend <0 && divisor >0){
            sign=false;
        }
        long n=Math.abs((long)dividend); //for overflow issues,as if dividend =INT MIN then abs will give the no extending integer max
        long d=Math.abs((long)divisor);
        
        int cnt=0;
        while(n>=d){
           int i=0;
           while(n>=(d<<(i+1))){
            i++;
           }
           cnt+=(1<<i);
           n=n-(d<<(i));
        }
        
        return sign ? cnt : (-1*cnt);
    }
}