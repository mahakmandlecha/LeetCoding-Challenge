class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int cost =0;
        int l = costs.length;
        for(int i=0;i<l;i++){
            cost += costs[i][0];
        }
        int[] difference = new int[l];
        for(int i=0;i<l;i++){
            difference[i] = costs[i][1]-costs[i][0];
        }
        Arrays.sort(difference);
        for(int i=0;i<l/2;i++){
            cost+=difference[i];
        }
        return cost;
    }
}