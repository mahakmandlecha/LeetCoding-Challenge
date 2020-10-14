class Solution {
    
    static int[] dp = new int[1000000];
    
    public int steps(int x) {
        if(x==1) {
            return 0;
        }
        
        if (dp[x] == -1) {
            // if x is odd that least significant bit will be 1 else it will be 0
            if ((x & 1) == 1) {
                dp[x] = steps(3 * x + 1) + 1;
            } else {
                dp[x] = steps(x / 2) + 1;
            }
        }
        return dp[x];
    }
    
    public int getKth(int lo, int hi, int k) {
      
      ArrayList<Pair <Integer,Integer> > ans = new ArrayList <Pair <Integer,Integer> >(); 
        
      for(int i=0;i<dp.length;i++) {
          dp[i] = -1;
      }  
      
      // moving in powers of 2
      int p = 1;
      for (int i = 0; i <= 15; i++) {
        dp[p << i] = i;
      }
    
      for (int i = lo; i <= hi; i++) {
            int res = steps(i);
            ans.add(new Pair <Integer,Integer>(i,res));
      }
      
      // Custom Comparator Passed As Argument
      Collections.sort(ans, new Comparator<Pair<Integer, Integer>>() {
        @Override
        public int compare(final Pair<Integer, Integer> p1, final Pair<Integer, Integer> p2) {
         int comparison = p1.getValue().compareTo(p2.getValue());
         if(comparison == 0) {
             comparison = p1.getKey().compareTo(p2.getKey());
         }
         return comparison;
       }});
        
      return ans.get(k-1).getKey();   
    }
}
