/*
floyd-warshall algorithm: use a two-dimensional array to store the minimum cost required for i to j to pass k
*/

/*
floyd-warshall algorithm: use a two-dimensional array to store the minimum cost required for i to j to pass k
*/

class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        List<Boolean> res = new ArrayList();
        int[][] disto = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(disto[i], 1000);
            disto[i][i] = 0;
        }
        for(int[] arr: prerequisites){
            disto[arr[0]][arr[1]] = 1;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (disto[i][j] > disto[i][k] + disto[k][j])
                        disto[i][j] = disto[i][k] + disto[k][j];
                }
            }
        }
        for(int i = 0; i < queries.length; i++){
            if(disto[queries[i][0]][queries[i][1]] == 1000) res.add(false);
            else res.add(true);
        }
        return res;
    }
}
