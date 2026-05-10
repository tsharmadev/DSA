class Solution {
    public int sumOfPrimesInRange(int n) {
        int original=n;
        int rev=0;
        while(n!=0){
            int digit=n%10;
            rev=rev*10+digit;
            n=n/10;
        }

        int min_val=Math.min(original,rev);
        int max_val=Math.max(original,rev);
        int sum=0;
        for(int i=min_val;i<=max_val;i++){
            if(i<2) continue;
            boolean is_prime=true;
            for(int j=2;j<=Math.sqrt(i);j++){
                if(i%j==0){
                   is_prime=false;
                    break;
                }
            }
            if(is_prime) {
                sum=sum+i;
            }
    
        }
        return sum;
    }
}