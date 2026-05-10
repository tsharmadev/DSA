class Solution {
public:
    vector<int> getRow(int rowIndex) {
        vector<int> temp;
        long long ans=1;
        temp.push_back(1);
        int column=rowIndex+1;
        for(int col=1;col<column;col++){
            ans=ans*((rowIndex+1)-col);
            ans=ans/col;
            temp.push_back(ans);
        }
    return temp;
    }
};