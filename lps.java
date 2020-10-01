class Solution {
    public char[] preprocess(String s){
        char[] t = new char[2*s.length()+3];
        t[0] = '$';
        t[2*s.length()+2] = '@';
        for(int i=0;i<s.length();i++){
            t[2*i+1] = '#';
            t[2*i+2] = s.charAt(i);
        }
        t[2*s.length()+1] = '#';
        return t;
    }
    public String longestPalindrome(String s) {
        char[] t = preprocess(s);
        int[] p =new int[t.length];
        int center = 0, right =0;
        for(int i=1;i<t.length-1;i++){
            int mirror = 2*center - i;
            if(i<right)
                p[i] = Math.min(p[mirror],right-i);
            while(t[ i + (1+p[i]) ] == t [ i - (1+p[i]) ])
                p[i]++;
            if(i+p[i] > right){
                center = i;
                right = i + p[i];
            }
        }
        return longestSubstring(p,s);
    }
    public String longestSubstring(int[] p ,String s){
        int maxlength = 0;
        int center = 0;
        for(int i=1;i<p.length-1;i++){
            if(p[i]>maxlength){
                maxlength = p[i];
                center = i;
            }
        }
        return s.substring( (center-1-maxlength)/2,(center-1+maxlength)/2 );
    }
    
}
