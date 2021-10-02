class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        
        for(int i=0;i<n;i++) {
            if(color[i]==0 && !dfs(graph,color,1,i)){
                return false;
            }
        }
        
        return true;
    }
    
    public boolean dfs(int[][] graph, int[] color, int old, int node){
        if(color[node]!=0)
            return color[node]==old;
        color[node] = old;
        for(int x:graph[node]) {
            if(!dfs(graph,color,-old,x))
                    return false;
        }
        return true;
    }
}
