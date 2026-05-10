class Solution {
public:
    
    vector<int> generaterows(int row ){       //made mstk here..taking col as parameter bu then row will show error as it's undefined...and col we are also taking in loop so take row as row and column will be same
        vector<int> temp;
        long long ans=1;
        temp.push_back(1);
        for(int col=1;col<row;col++){
            ans=ans*(row-col);
            ans=ans/col;
            temp.push_back(ans);
        }
    return temp;         //return the computed row
    }

    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> rows;
        for(int row=1;row<=numRows;row++){
        // vector<int> generaterows(row);  
        // rows.push_back(temp);        will show error this way as temp is not defined in    this functiom
        rows.push_back(generaterows(row));
        }
        return rows;
    }

    //made mstk here in loop..
};