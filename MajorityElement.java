class Solution {
    public int majorityElement(int[] nums) {
        int res=0;
        int n= nums.length;
        
        for(int i:nums)
        {
            int count=0;
            for(int j :nums)
            {
                if(i==j)
                    count++;
                
            }
            if(count>n/2)
                    return i;
        }
        return -1;
    }
}
