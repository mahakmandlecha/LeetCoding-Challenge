class Solution {
    public boolean checkStraightLine(int[][] c) {
        if(c.length==2)
            return true;
        for(int i=1;i<c.length-1;i++)
        {
            int x1=c[i-1][0];
            int x2=c[i][0];
            int x3=c[i+1][0];
            int y1=c[i-1][1];
            int y2=c[i][1];
            int y3=c[i+1][1];
            
           if((y2-y1)*(x3-x2)!=(y3-y2)*(x2-x1))
               return false;
            
        }
        return true;
    }
}
