class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int n=nums.size();
        int can=0;
        int count=0;
        for(auto i:nums)
        {
            if(count==0)
            {
                can=i;
            }
            if(can==i)
            {
                count++;
            }
            else
            {
                count--;
            }
        }
        return can;
    }
};
