class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if(nums.size() < 2) return nums.size();
        int currentDupElmInd = 0;
        for(int i = 1; i < nums.size(); i++){
            if(nums[currentDupElmInd] != nums[i])
                nums[++currentDupElmInd] = nums[i];
        }
        return currentDupElmInd + 1;
        
    }
};
