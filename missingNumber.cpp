class Solution {
public:
    int missingNumber(vector<int>& v) {
        int n=v.size();
        return ((n+1)*n)/2-accumulate(v.begin(),v.end(),0);
    }
};
