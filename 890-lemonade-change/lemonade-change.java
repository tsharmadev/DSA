class Solution {
    public boolean lemonadeChange(int[] bills) {
        //your code goes here
        int five=0;
        int ten=0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                five++;
            }
            if(bills[i]==10){
                if(five>=1){
                    five--;
                    ten++;
                }
                else{
                    return false;
                }
            }
            if(bills[i]==20){
                if((ten>=1)&&(five>=1)){
                    five=five-1;
                    ten=ten-1;
                }
                else if(five>=3){
                   five=five-3;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}