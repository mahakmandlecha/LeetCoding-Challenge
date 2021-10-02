class Solution {
    
    int[] dr = new int[]{-1,0,1,0};
    int[] dc = new int[]{0,-1,0,1};
    
    public int largestIsland(int[][] grid) {
        
        int N = grid.length;
        int ans = 0;
        boolean hasZero = false;
        
        for(int r=0;r<N;r++) {
            for(int c=0;c<N;c++) {
                if(grid[r][c]==0) {
                    hasZero = true;
                    grid[r][c]=1;
                    ans = (int)Math.max(ans,check(grid,r,c));
                    grid[r][c]=0;
                }
            }
        }
        
        return hasZero?ans:N*N;
        
    }
    
    public int check(int[][] grid, int r, int c){
        int N = grid.length;
        
        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();
        stack.push(r*N+c);
        set.add(r*N+c);
        
        while(!stack.isEmpty()) {
            int temp = stack.pop();
            int x = temp/N;
            int y = temp%N;
            for(int k=0;k<4;k++){
                int nr = x + dr[k];
                int nc = y + dc[k];
                if(!set.contains(nr*N+nc) && nr>=0 && nr<N && nc<N && nc>=0 && grid[nr][nc]==1) {
                    stack.push(nr*N+nc);
                    set.add(nr*N+nc);
                }
            }
        }
        
        return set.size();
    }
}

