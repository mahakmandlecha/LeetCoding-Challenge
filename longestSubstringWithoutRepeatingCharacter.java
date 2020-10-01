class Solution {
            
    public int lengthOfLongestSubstring(String s) {
        int i=0;
        int n = s.length();
        int prev[] = new int[256];
        Arrays.fill(prev,-1);
        int res=0;
        for(int j=0;j<n;j++){
            i = Math.max(i,prev[s.charAt(j)]+1);
            res = Math.max(res,j-i+1);
            prev[s.charAt(j)]=j;
        }
        return res;
    }
}
