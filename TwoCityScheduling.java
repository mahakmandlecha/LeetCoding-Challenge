class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        int n=costs.length/2;
       int[] ref=new int[n*2];
       int index=0,minCost=0;
        for(int[] c:costs){
            ref[index++]=c[1]-c[0];
            minCost+=c[0];
            
        }
        Arrays.sort(ref);
        for(int i=0;i<n;i++){
            minCost+=ref[i];
        }
        return minCost;
    }
}
