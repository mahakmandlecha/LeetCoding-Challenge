class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        int n=costs.length;
        int m=costs[0].length;
        int sum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sum+=Math.min(costs[0][j],costs[i][0]);
            }
        }
        return sum;
    }
}