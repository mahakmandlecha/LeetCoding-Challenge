class Solution {
    
    
    public int maxProduct(int[] nums) {
        
        int n = nums.length;
        int ans  = Math.max(nums[0],nums[n-1]), l = nums[0], r = nums[n-1];
                
        for(int i=1;i<nums.length;i++) {
            l = (l==0?1:l)*nums[i];
            r = (r==0?1:r)*nums[n-1-i];
            ans = (int)Math.max(ans,Math.max(l,r));
        }
        
        return ans;
    }
}
