class Solution {
    public boolean isPerfectSquare(int num) {
        int res=2;
        if(num==1)
            return true;
        while(res<=(num/2))
        {
            if(res*res==num)
                return true;
            res++;
            
        }
        return false;
    }
}
