struct sort_right {
    bool operator()(vector<int>& left, vector<int>& right) {
        return left[0] < right[0];
    }
};

class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        if(intervals.size()  < 2) return intervals;
        vector<vector<int>> out;
        
        sort(intervals.begin(), intervals.end(), sort_right());
        
        out.push_back(intervals[0]);
        
        for(int i = 1; i < intervals.size(); i++){
            if(out.back()[1] >= intervals[i][0]) {
                out.back()[1] = max(out.back()[1], intervals[i][1]);
            }
            else out.push_back(intervals[i]);
        }
        return out;
    }
};
