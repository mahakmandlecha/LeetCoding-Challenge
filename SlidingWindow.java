class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        
        for(int i=0;i<k;i++) {
            
            while(dq.size()!=0 && nums[i]>=nums[dq.getLast()]){
                dq.pollLast();
            }
            dq.offerLast(i);           
        }
        
        int n = nums.length;
        
        int[] res = new int[n-k+1];
        int index = 0;
        
        for(int i=k;i<n;i++) {
            res[index++] = nums[dq.getFirst()];
            while(dq.size()>0 && dq.getFirst()<=i-k){
                dq.pollFirst();
            }
           while(dq.size()!=0 && nums[i]>=nums[dq.getLast()]){
                dq.pollLast();
            }
            dq.offerLast(i);           
        }
        res[index++] = nums[dq.getFirst()];
        return res;
        
        
    }
}
