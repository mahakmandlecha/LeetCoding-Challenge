class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        if(nums.size()==1 && nums[0]==val)
            return 0;
        int low=0,high=nums.size()-1;
        
        while(low<=high){
            if(nums[low]==val){
                swap(nums[low],nums[high--]);
            } else{
                low++;
            }
        }
        return low;
    }
};