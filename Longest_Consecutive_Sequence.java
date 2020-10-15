class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)
            return 0;
        int res=1;
        if(nums.length==1)
            return 1;
        HashSet<Integer> hash = new HashSet<>();
        for(int n:nums)
            hash.add(n);
        for(int i=0;i<nums.length;i++)
        {
            if(hash.contains(nums[i]-1))
            {
                int curr=1;
                while(hash.contains(nums[i]-curr))
                    curr++;
                res= Math.max(res,curr);
            }
        }
        return res;
    }
}
